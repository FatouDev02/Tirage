package com.example.ApiTirage.excel;

import com.example.ApiTirage.Models.Postulants;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelFileConfig {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    public static  Boolean verifier(MultipartFile multipartFile){
      if(TYPE.equals(multipartFile.getContentType())){
          return true;
      }else{
          return false;
      }
    }
    public static List<Postulants>  postulantsExcel(MultipartFile multipartFile){

        try{
            //creation d'une liste dans laquelle on va mettre la liste recupérée
            List<Postulants> postulants=new ArrayList<Postulants>();

            //lecture du fichier
            Workbook workbook=new XSSFWorkbook(multipartFile.getInputStream());
            Iterator<Sheet> sheet=workbook.sheetIterator();

            DataFormatter formatter=new DataFormatter();

            while(sheet.hasNext()){
                int n_ligne=0;
                Sheet sheet1=sheet.next();
                Iterator<Row> rowIterator=sheet1.rowIterator();

                //parcour du fichier excel ligne par ligne
                while (rowIterator.hasNext()){
                    Row row=rowIterator.next();
                    Iterator<Cell> cellIterator = row.iterator();
                    if (n_ligne == 0){
                        n_ligne++;
                        continue;
                    }
                    //Apres la lescture d'une ligne un postulants sera creer en recuperant ses attributs
                    Postulants postulants1=new Postulants();

                    int n_colonne =0;
                    //parcourir le scolonees d'une ligne
                    while(cellIterator.hasNext()){
                        //Recuperation de la colonne courante
                        Cell currentcell = cellIterator.next();
                        //Recuperation des données de chaque colonne
                        switch (n_colonne){
                            case 0:
                                postulants1.setNom(formatter.formatCellValue(currentcell));
                                break;
                                //deuxieme colonne contenant le nom
                            case 1:
                                postulants1.setPrenom(formatter.formatCellValue(currentcell));
                                break;
                            //3eme colonne contenant le nom
                            case 2:
                                postulants1.setNumero(formatter.formatCellValue(currentcell));
                                break;
                            //4eme colonne contenant le nom
                            case 3:
                                postulants1.setEmail(formatter.formatCellValue(currentcell));
                                break;
                            default:
                                break;
                        }
                        n_colonne++;
                    }
                    postulants.add(postulants1);
                    //n_ligne++;
                }
            }
            workbook.close();
            return postulants;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
