

package com.control.almacen.serviceImplement.excel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExecelToolLeer {

    private static final Logger LOG = LoggerFactory.getLogger(ExecelToolLeer.class);

    String nombreArchivo = "Inventario.xlsx";
    String rutaArchivo = "C:\\Ficheros-Excel\\" + nombreArchivo;
    String hoja = "Hoja1";


    public ExecelToolLeer(String nombreArchivo, String rutaArchivo, String hoja) {
        this.nombreArchivo = nombreArchivo;
        this.rutaArchivo = rutaArchivo;
        this.hoja = hoja;
    }


    private void LeerFicheros() {
        try (FileInputStream file = new FileInputStream(new File(rutaArchivo))) {
            //leer archivo excel
            XSSFWorkbook worbook = new XSSFWorkbook(file);
            //obtener la hoja que se va leer
            XSSFSheet sheet = worbook.getSheetAt(0);
            //obtener todas las filas de la hoja excel
            Iterator<Row> rowIterator = sheet.iterator();
            Row row;
            // se recorre cada fila hasta el final
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                //se obtiene las celdas por fila
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell;
                //se recorre cada celda
                while (cellIterator.hasNext()) {
                    // se obtiene la celda en espec�fico y se la imprime o se guarda en donde se requiere
                    cell = cellIterator.next();
                    System.out.print(cell.getStringCellValue() + " | ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }


}
