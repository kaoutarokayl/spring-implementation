/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import dao.IDao;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;
import metier.IMetier;


public class Presentation2 {

    public static void main(String[] args) throws Exception {
        // Lecture du nom de la classe DAO depuis le fichier deconfiguration
        Scanner scanner = new Scanner(new File("config.txt"));
        String daoClassName = scanner.nextLine();
        // Utilisation de la réflexion pour charger la classe DAOet créer une instance
        Class<?> cDao = Class.forName(daoClassName);
        IDao dao = (IDao) cDao.getDeclaredConstructor().newInstance();
        // Lecture du nom de la classe Métier depuis le fichier de configuration
        String metierClassName = scanner.nextLine();
        Class<?> cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.getDeclaredConstructor().newInstance();
        // Injection de la DAO dans le Métier àl'aide de la réflexion
        Method setDaoMethod = cMetier.getMethod("setDao",
                IDao.class);
        setDaoMethod.invoke(metier, dao);
        // Invocation d'une méthode sur l'instance de Métier et affichage du résultat
        System.out.println("Résultats = " + metier.calcul());
        scanner.close();
    }
}
