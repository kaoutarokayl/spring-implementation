# TP : Implémentation de l'Inversion de Contrôle et Injection des Dépendances avec Spring.

## Objectif
L'objectif de ce travail pratique est de créer une application Java utilisant le framework Spring pour mettre en œuvre l'inversion de contrôle (IoC) et l'injection de dépendances (DI). Ce projet vise à développer des interfaces et des classes, tout en gérant l'injection des dépendances entre elles.

## Contexte
Ce TP consiste à créer une application qui utilise des interfaces pour le calcul d'une valeur. L'application doit tirer parti des annotations Spring pour gérer les beans et les dépendances, permettant ainsi une configuration dynamique et flexible.

## Étapes de réalisation

1. **Création de l'interface IDao**
   - Création d'un package nommé `dao` et ajout de l'interface `IDao` qui définit la méthode `getValue()` retournant un double.

   ```java
   package dao;
   public interface IDao {
       double getValue();
   }
2. **Implémentation de DaoImpl**

Création de la classe DaoImpl qui implémente IDao et retourne une valeur fixe (100.0) dans la méthode getValue().
package dao;
import org.springframework.stereotype.Component;

@Component("dao")
public class DaoImpl implements IDao {
    @Override
    public double getValue() {
        return 100.0;
    }
}
3. **Création de l'interface IMetier**

Création d'un package metier et ajout de l'interface IMetier qui définit la méthode calcul().
package metier;
public interface IMetier {
    double calcul();
}
4. **Implémentation de MetierImpl**

Ajout de la classe MetierImpl dans le package metier, qui implémente IMetier et utilise IDao pour effectuer des calculs.
package metier;
import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier {
    @Autowired
    private IDao dao;

    @Override
    public double calcul() {
        return dao.getValue() * 2;
    }
}
5. **Création de la classe Presentation2**

Création de la classe Presentation2 dans un package presentation, qui récupère les beans Spring et affiche le résultat.
package presentation;
import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"dao", "metier"})
public class Presentation2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Presentation2.class);
        IMetier metier = context.getBean(IMetier.class);
        System.out.println("Résultat = " + metier.calcul());
    }
}
 6. **Configuration**
S'assurer d'avoir les dépendances nécessaires dans le fichier pom.xml pour Spring. Voici un exemple de dépendance :

<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.22</version>
    </dependency>
</dependencies>
Exécution du projet
Pour exécuter le projet, compilez et exécutez la classe Presentation2. Si tout est correctement configuré, le résultat attendu dans la console sera :

Résultat = 200.0
## Vidéo démonstrative



https://github.com/user-attachments/assets/b8a33a1a-4d2e-4737-b08e-6fe00fd893f3


## Conclusion
Ce TP m'a permis de comprendre les principes de l'inversion de contrôle et de l'injection de dépendances avec Spring. L'utilisation de ces concepts facilite la création d'applications plus flexibles et modulaires, tout en améliorant la maintenabilité du code.

