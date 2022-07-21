import java.io.IOException;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tx_web {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        web();
    }
    private static void web( ) throws IOException{
        // TODO Auto-generated method stub

        URL url = new URL("http://bbs.tianya.cn/post-enterprise-758850-1.shtml");
        URLConnection connection = url.openConnection();
        BufferedReader buffer = new BufferedReader(new InputStreamReader( connection.getInputStream() ) );

        String line = null;
        String mailreg = "\\w+@\\w+(\\.\\w+)+"; //Email的通配符
        Pattern pattern = Pattern.compile(mailreg);

        //matcher:匹配
        while (( line = buffer.readLine() ) != null) {
            Matcher matcher = pattern.matcher(line);
            while ( matcher.find() ) {
                String string = matcher.group();
                List<String> list = new ArrayList<String>();
                list.add(string);
                for ( String string2 : list ) {
                    tx_Jdbc.insert(list);
                    System.out.println( string2 );
                }
            }
        }
    }
}
