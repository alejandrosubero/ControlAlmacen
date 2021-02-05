
/*
Create on Sat Jan 30 15:24:51 ART 2021
*Copyright (C) 121.
@author alejandro
@author Hugo Luna
@author ANACODE AND IVANCODE
@since 11.0
@version1.0.0.0
@version  %I%, %G%
*<p>Description: control de  almacen </p>
*/



package com.control.almacen.serviceImplement.archivos;
import net.lingala.zip4j.core.ZipFile; 
import net.lingala.zip4j.exception.ZipException; 
import net.lingala.zip4j.model.ZipParameters; 
import net.lingala.zip4j.util.Zip4jConstants; 
import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.InetAddress; 
import java.net.UnknownHostException;
import java.io.IOException;
 


@Component
public class ArchivosManament {

protected static final Log logger = LogFactory.getLog(ArchivosManament.class);
private boolean isEncryptFiles = false;
private String password = "12345";
private String barra ="\\";


    public void crearArchivo(String direccion, String escrito, String nombreArchivo) {
         String carpetas = direccion;
         String archivos = barra + nombreArchivo;
         String contenido1 = escrito;
         File create_carpeta = new File(carpetas);
         File create_archivo = new File(carpetas + archivos);
         if (create_archivo.exists()) {
    } else {
         create_carpeta.mkdirs();
    try {
    if (create_archivo.createNewFile()) {
         FileWriter fw = new FileWriter(create_archivo);
         BufferedWriter bw = new BufferedWriter(fw);
         bw.write(contenido1);
         bw.close();
    } else {
    }
    } catch (IOException e) {
         e.printStackTrace();
    }
    }
    }



    public static byte[] readBytesFromFile(String filePaths) {        String filePath = filePaths;         FileInputStream fileInputStream = null;        byte[] bytesArray = null;    try {        File file = new File(filePath);        bytesArray = new byte[(int) file.length()];        fileInputStream = new FileInputStream(file);        fileInputStream.read(bytesArray);    } catch (IOException e) {        e.printStackTrace();    } finally {        if (fileInputStream != null) {        try {         fileInputStream.close();    } catch (IOException e) {           e.printStackTrace();    }    }    }        return bytesArray;    }

 public void borrarFolder(String directorio) {    File f = new File(directorio);    this.borrarcarpetas(f);        }


    private void borrarcarpetas(File fileDel) {     if (fileDel.isDirectory()) {        if (fileDel.list().length == 0) {            fileDel.delete();    } else {        for (String temp : fileDel.list()) {        File fileDelete = new File(fileDel, temp);        borrarcarpetas(fileDelete);    }    if (fileDel.list().length == 0) {fileDel.delete();}    }    } else {        fileDel.delete();    }    }


     public void folderzip(String carpetaAcomprimir, String direccionDeCarpeta, String nombreArchivoZip) throws Exception {
        String folderpathZipInput = direccionDeCarpeta + carpetaAcomprimir; 
        String pathOutputZip = direccionDeCarpeta + nombreArchivoZip + ".zip"; 
    try {
        ZipFile zipFile = new ZipFile(pathOutputZip);
        ZipParameters parameters = new ZipParameters();
        parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
        parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
        parameters.setEncryptFiles(isEncryptFiles);
        parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
        parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
        parameters.setPassword(password);
        zipFile.addFolder(folderpathZipInput, parameters);
// JOptionPane.showMessageDialog(null, "El archivo zip se creo");
    } catch (ZipException e) {
// JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        e.printStackTrace();
// JOptionPane.showMessageDialog(null, "El archivo zip no se creo " + e);
         }
    }


   
 public String OsEjecutandose() {
 String usar = "";
 try {
        String hostName = java.net.InetAddress.getLocalHost().getHostAddress();
        InetAddress addr = InetAddress.getByName(hostName);
        String hostname = addr.getHostName();
        String so = System.getProperty("os.name");
        if (so.equals("Windows 10")) {
        usar = "\\";
  }else {
        usar = "//";
  }
        return usar;
  } catch (UnknownHostException e) {
        return "NO SE EJECUTOEL SCRIP EL ERROR: " + e;
     }
  }


}
 /*
 Copyright (C) 2008 Google Inc.
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/


