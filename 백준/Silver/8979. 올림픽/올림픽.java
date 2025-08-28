import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int country = Integer.parseInt(st.nextToken());
        int rank = Integer.parseInt(st.nextToken());

        ArrayList<Country> countries = new ArrayList<>();

        for(int i = 0; i < country; i++){
            st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            countries.add(new Country(number, gold, silver, bronze));
        }

        Collections.sort(countries);

        int index = 0;
        int result = 0;

        for(int i = 0; i < countries.size(); i++){
            Country ct = countries.get(i);

            if(ct.number == rank)
                index = i;
        }

        Country target = countries.get(index);

        for(int i = index-1; i >= 0; i--){
            Country compare = countries.get(i);

            if(compare.gold == target.gold && compare.silver == target.silver && compare.bronze == target.bronze){
                index = i;
            }
            else break;
        }

        System.out.println(index+1);
    }

    public static class Country implements Comparable<Country> {

        private int number;
        private int gold;
        private int silver;
        private int bronze;

        public Country(int number, int gold, int silver, int bronze){
            this.number = number;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Country country){
            if(this.gold != country.gold)
                return country.gold - this.gold;
            else if(this.silver != country.silver)
                return country.silver - this.silver;
            else return country.bronze - this.bronze;
        }

    }

}

