import java.io.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamBasics {
    public static void main(String[] args) {

        System.out.println("970M");

        List<Humain> humainList = Arrays.asList(
                new Humain("Dupond", "Pierre", Arrays.asList("Jean", "Thomas"), 41, new Date(), 1932847305835L),
                new Humain("Marse", "Benoit", Arrays.asList("Marc"), 34, new Date(), 1174027416835L),
                new Humain("Camille", "Ferrera", Arrays.asList("Jordane", "Rose", "Julie"), 24, new Date(),
                        1052375173404L),
                new Humain("Christine", "Cardine", Arrays.asList("Helana", "Angelica"), 57, new Date(),
                        1539253522862L));

        System.out.println("humainList : " + humainList.get(0).nom);

        // transformer la list en stream, anyMath renvoi un booleen
        if (humainList.stream().anyMatch(humain -> humain.age >= 30)) {
            System.out.println("Il y a bien un humain agé de plus de 30 ans");
        }

        // filter renvoie un stream
        // fonction collect renvoi une collection
        List<Humain> vieuxHumainList = humainList.stream().filter(humain -> humain.age >= 30)
                .collect(Collectors.toList());
        // affichgage qui peut etre effectué avec des streams
        vieuxHumainList.forEach(x -> System.out.println(x.nom));

        // - ------------------------------
        // map pour recuperer une list avec les numero de SS
        System.out.println("Plus de 30 ans");
        List<Long> numSocialAgePlus30Ans = humainList.stream().filter(humain -> humain.age >= 30)
                .map(x -> x.numeroSocial)
                .collect(Collectors.toList());
        numSocialAgePlus30Ans.forEach(x -> System.out.println(x));
        // - ------------------------------
        // Avec l'affichage intégré
        System.out.println("Moins de 30 ans");
        humainList.stream().filter(humain -> humain.age < 30)
                .map(x -> x.numeroSocial)
                .collect(Collectors.toList()).forEach(x -> System.out.println(x));

        // - ------------------------------
        // flatMap
        System.out.println("Plus de 30 ans (flatMap");
        List<String> autrePrenomAgePlus30Ans = humainList.stream().filter(humain -> humain.age >= 30)
                .flatMap(x -> x.autresPrenomList.stream())
                .collect(Collectors.toList());

        autrePrenomAgePlus30Ans.forEach(x -> System.out.println(x));
        System.out.println(autrePrenomAgePlus30Ans);

        // - ------------------------------
        // Autres fonctions utiles
        // count() : renvoyer le nombre d'éléments
        Long nbH = humainList.stream().count();
        System.out.println(nbH);
        // distinct() : eliminer les doublons
        humainList.stream().distinct();
        // fondFirst : renvoyer le premier element correspondant au prédicat defini dans filter
        Humain premierHumain = humainList.stream().filter(humain -> humain.age > 30).findFirst().get();
        System.out.println(premierHumain.nom);
    }

    public static class Humain {

        String nom;
        String prenom;
        List<String> autresPrenomList;
        Integer age;
        Date dateNaissance;
        Long numeroSocial;

        public Humain(String n, String p, List<String> ap, Integer a, Date d, Long nss) {
            this.nom = n;
            this.prenom = p;
            this.autresPrenomList = ap;
            this.age = a;
            this.dateNaissance = d;
            this.numeroSocial = nss;
        }
    }

}