package com.company;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main{

    public static void main(String[] args) throws IOException{
            Stream<String> lines = Files.lines(Paths.get("mammals.txt"));
            Map<String, Mammal> map;

            //tworzenie mapy
            map = lines
                    .map(line -> line.split(";"))
                    .collect(Collectors.toMap(
                            x -> x[0],
                            x -> new Mammal(toDouble(x[1]), toDouble(x[2]), toDouble(x[3]), toDouble(x[4]), toDouble(x[5]), toDouble(x[6]), toDouble(x[7]), (int) toDouble(x[8]), (int) toDouble(x[9]), (int) toDouble(x[10]))
                    ));
            map.remove("species");
            map.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey(Comparator.comparingInt(String::length)))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (x, y) -> y, LinkedHashMap::new))
                    .entrySet()
                    .forEach(x -> System.out.println(x.toString()));

            System.out.print("\nThe heaviest animals: ");
            map.entrySet().stream()
                    .max(Map.Entry.comparingByValue(Mammal::compareTo))
                    .map(Map.Entry::getKey).ifPresent(System.out::println);

            System.out.println("\n3 animals with the longest sleep coefficient ");
            map.entrySet().stream()
                    .filter(x -> x.getValue().getDreaming() != 0.0 && x.getValue().getTotal_sleep() != 0.0 && x.getValue().getNot_dreaming() != 0.0)
                    .sorted(Map.Entry.comparingByValue(Mammal::comTo))
                    .limit(3)
                    .forEach(x -> System.out.println(x + "\nProcent snów: " + x.getValue().dreamingPercentage() + "%"));

            System.out.println("\nAnimals living above the average lifespan:");
            Map<String, Mammal> finalMap = map;
            map.entrySet().stream()
                    .filter(x ->
                            x.getValue().getLife_span() > finalMap.values().stream()
                                    .mapToDouble(Mammal::getLife_span).average().getAsDouble())
                    .forEach(x->System.out.println(x.getKey()));

            //tworzenie listy
            List<Mammal> list = map.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Mammal::comTo2)).limit(3)
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toList());
            System.out.println("\nPrinting an array");
            list.forEach(System.out::println);

                Bufor db = new Bufor();
                Thread feed = new Feeding1(list,db);
                Thread burn = new Burning1(db, list);
                feed.start();
                burn.start();
        }
    static double toDouble(String k){
        if(k.equals("NA")){
            return 0;
        }else {
            double a = 0;
            double b = 1;
            boolean dot = false;
            for (int i = 0; i < k.length(); i++) {
                if (k.charAt(i) == '.') {
                    dot = true;
                    a/=10;
                    continue;
                }
                if (dot) {
                    b /= 10;
                    a += (k.charAt(i) - '0') * b;
                } else {
                    a += k.charAt(i) - '0';
                    a *= 10;
                }
            }
            if(dot){
                a = Math.round(a*1000.0)/1000.0;
            }
            if(!dot){
                a/=10;
            }
            return a;
        }
    }
}

