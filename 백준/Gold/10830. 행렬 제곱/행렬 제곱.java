import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[][] matrix;
    public static int[][] answer;
    public static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        matrix = new int[n][n];
        answer = new int[n][n];

        long pow = Long.parseLong(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
            answer[i][i] = 1;
        }

        while(pow > 0){
            if(pow % 2 == 1){
                answer = matrixMulti(answer, matrix);
            }
            matrix = matrixMulti(matrix, matrix);
            pow /= 2;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int[][] matrixMulti(int[][] mat1, int[][] mat2){

        int[][] result = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    result[i][j] += mat1[i][k] * mat2[k][j];
                    result[i][j] %= 1000;
                }
            }
        }

        return result;
    }

}
