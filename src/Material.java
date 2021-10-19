import java.sql.Timestamp;    
import java.util.Date;    
import java.text.SimpleDateFormat; 

public class Material {
	protected String getTimeStamp() {
		Date date = new Date();  
        Timestamp ts=new Timestamp(date.getTime());  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");  
        String s = formatter.format(ts);
        return s;
	}
}
