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
/*MultipartFile :Représentation d’un fichier téléchargé reçu dans une demande en plusieurs parties.*/
    public static  Boolean verifier(MultipartFile multipartFile){
      if(TYPE.equals(multipartFile.getContentType())){
          return true;
      }else{
          return false;
      }
    }
    /*MultipartFile :Représentation d’un fichier téléchargé reçu dans une demande en plusieurs parties.*/
    public static List<Postulants>  postulantsExcel(MultipartFile multipartFile){

        try{
            //creation d'une liste dans laquelle on va mettre la liste recupérée
            List<Postulants> postulants=new ArrayList<Postulants>();

            //lecture du fichier
            // Workbook class :Représente un objet racine pour créer une feuille de calcul Excel.
            // XSSFWorkbook: l’objet de niveau supérieur pour la création de nouvelles feuilles / etc.
            Workbook workbook=new XSSFWorkbook(multipartFile.getInputStream());

            //Sheet represent la feuille de calcul, on la rend iterable pour pouvoir la parcourir

            Iterator<Sheet> sheet=workbook.sheetIterator();

            DataFormatter formatter=new DataFormatter();
//DataFormatter contient des méthodes de mise en forme de la valeur stockée
// dans une cellule. Cela peut être utile pour les rapports et les présentations d’interface
// graphique lorsque vous devez afficher les données exactement telles qu’elles apparaissent dans Excel
            while(sheet.hasNext()){//tant que la ligne svte n'est pas null
                int n_ligne=0;
                Sheet sheet1=sheet.next();
                //rendre les lignes de la feuille(sheet) iterable
                Iterator<Row> rowIterator=sheet1.rowIterator();

                //parcourt du fichier excel ligne par ligne
                while (rowIterator.hasNext()){
                    Row row=rowIterator.next();
                    //rendre les colonnes de la feuille(sheet) iterable
                    Iterator<Cell> cellIterator = row.iterator();
                    if (n_ligne == 0){
                        n_ligne++;
                        continue;// est utilisé pour terminer
                        // l’itération en cours dans une boucle (ou une boucle) et passe à l’itération suivante.
                    }
                    //Apres la lescture d'une ligne un postulants sera creer en recuperant ses attributs
                    Postulants postulants1=new Postulants();

                    int n_colonne =0;
                    //parcourir les colonnes d'une ligne
                    while(cellIterator.hasNext()){//tant que la cellule svte n'est pas null
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
                                postulants1.setNumero(Long.valueOf(formatter.formatCellValue(currentcell)));
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
