package vn.cwa.application.app;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.util.ReflectionUtils;

import vn.cwa.application.domain.model.Student;

public class Main {

  public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
    // Student s1 = new Student();
    // s1.setIdT(1L);
    // s1.setName("nkm1");
    // s1.setAge(18);
    //
    // Student s2 = new Student();
    // s2.setIdT(1L);
    // s2.setName("nkm1");
    // s2.setAge(18);
    //
    // if (s1.hashCode() == s2.hashCode()) {
    // System.out.println("s1 == s2");
    // } else {
    // System.out.println("s1 != s2");
    // }

    // String[] testStr = new String[] {"mot","hai","ba"};
    // String x = "ba";
    // if (Arrays.asList(testStr).contains(x)) {
    // System.out.println("ton tai chuoi");
    // }else {
    // System.out.println("khong ton tai chuoi");
    // }

    // List<Integer> lst = new ArrayList<>();
    // Integer test = null;
    // for (int i = 0; i < 10; i++) {
    // test = i;
    // lst.add(test);
    // }
    // System.out.println(lst);

    // Map<Integer, String> testMap = new HashMap<Integer, String>();
    // testMap.put(1, "mot");
    // testMap.put(2, "hai");
    // testMap.put(3, "ba");
    //
    // String sql = testMap.entrySet().stream().map(item -> item.getKey() + "=" +
    // item.getValue()).collect(Collectors.joining(","));
    // System.out.println(sql);

    // String sEmail = "nkm081198@gmail.com";
    // String domain = sEmail.substring(sEmail.lastIndexOf("@") + 1);
    // String account = sEmail.substring(0, sEmail.indexOf("@"));
    // System.out.println(account);
    // System.out.println(domain);

    // String domain = "abcdefgd";
    // int x = domain.indexOf("d");
    // System.out.println(x);

    // Student student = new Student();
    // Field[] fields = student.getClass().getDeclaredFields();
    //
    // for (Field field : fields) {
    // if (field.getName().equals("parameter")) {
    // field.setAccessible(true);
    // if (field.get("parameter") != "") {
    // return true;
    // }
    // }
    // }
    // return false;

    // String day = "08";
    // String month = "11";
    // String year = "1998";
    // Date date = new Date();
    // try {
    // String birth = new
    // StringBuilder().append("1998").append("-").append("02").append("-").append("31")
    // .toString();
    // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    // date = sdf.parse(birth);
    // } catch (ParseException e) {
    // date = null;
    // System.out.println(e.getMessage());
    // }
    //
    // String rs = new SimpleDateFormat("yyyy-MM-dd").format(date);
    // System.out.println(rs);

    // String dateString = "2024-2-2";
    // DateValidator dateValidator = new DateValidator();
    // boolean x = isDateValid(dateString, "yyyy-MM-dd");
    // System.out.println(x);

    // SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    // Date date = null;
    // try {
    // date = formatDate.parse(dateString);
    //
    // } catch (Exception e) {
    // System.out.println(e.getMessage());
    // }
    //
    // System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));

    // String test = "manh-dep(trai)vl";
    // String str = test.replace("-", "").replace("(", "").replace(")", "");
    // System.out.println(str);

    // String[] rej = new String[] { "-", "(", ")" };
    // String v1 = "manh-dep(trai)vl";
    //
    // v1 = replaceMultipleCharacters(v1,"","-","(",")");
    // System.out.println(v1);

    // String input = "a b c d";
    // String rs = pregReplace("[\\s]+"," ",input);
    // System.out.println(rs);

    // String dob = "08/01/1998";
    // Calendar calendar = Calendar.getInstance();
    // try {
    // calendar.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dob));
    // } catch (ParseException e) {
    // System.out.println(e.getMessage());
    // }
    //
    // int day = calendar.get(Calendar.DAY_OF_MONTH);
    // int month = calendar.get(Calendar.MONTH) + 1;
    // int year = calendar.get(Calendar.YEAR);
    //
    // System.out.println(day + "/" + month + "/" + year);

    // Student st = new Student();
    // st.setName("nkm");
    // st.setAge(18);
    // ObjectMapper objectMapper = new ObjectMapper();
    // Map<String, Object> stMap = objectMapper.convertValue(st, Map.class);
    // System.out.println(stMap);
    // st.setName("manh1");
    //
    // System.out.println(stMap);

    // Map<String, Object> map1 = new HashMap<String, Object>();
    // Map<String, Object> map2 = new HashMap<String, Object>();
    // map1.put("key1", 1);
    // map2.put("key1", 1);
    // if(map1.get("key1").hashCode() != map2.get("key1").hashCode()) {
    // System.out.println("if");
    // } else {
    // System.out.println("else");
    // }

    // if(!map1.get("key1").equals(map2.get("key1"))) {
    // System.out.println("if");
    // } else {
    // System.out.println("else");
    // }

    // Map<String, Object> val = new HashMap<String, Object>();
    // val.put("コンタクトID", 111);
    // val.put("Emailアドレス", 222);
    // val.put("オーナーフラグ", 333);
    // val.put("NLO会員状態", 444);
    //
    // String str = val.entrySet().stream().map(item -> item.getKey() + ": " + item.getValue())
    // .collect(Collectors.joining("\n"));
    //
    // System.out.println(str);

    // DateCustome dateCustome = new DateCustome();
    // dateCustome.setDay(31);
    // dateCustome.setMonth(2);
    // dateCustome.setYear(1998);
    // Date date = null;
    // DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    // dateFormat.setLenient(false);
    // if (isNotBlankStringArr(dateCustome.getDay(), dateCustome.getMonth(), dateCustome.getYear()))
    // {
    //
    // String str = new
    // StringBuilder().append(dateCustome.getYear()).append("-").append(dateCustome.getMonth()).append("-").append(dateCustome.getDay()).toString();
    // try {
    // date = dateFormat.parse(str);
    // } catch (ParseException e) {
    // date = null;
    // System.out.println(e.getMessage());
    // }
    // } else {
    // date = null;
    // }
    // System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));

    // DateCustome dateCustome = new DateCustome();
    // dateCustome.setDay(31);
    // dateCustome.setMonth(2);
    // dateCustome.setYear(1998);
    // String str = new
    // StringBuilder().append(dateCustome.getYear()).append("-").append(dateCustome.getMonth()).append("-").append(dateCustome.getDay()).toString();

    // String dateString = "1999-2-31";
    // String dateType = "yyyy-MM-dd";
    // boolean rs = checkDateInvalid(str, dateType);
    // System.out.println(rs);
    // for (int i = 1; i <= 20; i++) {
    // System.out.println("<result column=\"yobi"+i+"\" property=\"yobi"+i+"\" />");
    // }

    // Student student = new Student();
    // student.setMaps(student.getMaps().put("", ""));
    // System.out.println(student.getMaps().put("", ""));

    // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    // LocalDateTime now = LocalDateTime.now();
    // Calendar cal = Calendar.getInstance();
    // System.out.println(dtf.format(now).toString() + "" + cal);

    // System.out.println(LocalDateTime.now());

    // Map<String, String> maps = testPutMap();
    // System.out.println(maps);
    // String key = null;
    // if(maps.containsKey(null)) {
    // System.out.println(maps.get(key));
    // } else {
    // System.out.println(maps.get(key));
    // }

    // String k = "h:";
    // String[] x = k.split(":");
    // String rs = (x.length == 2) ? x[3] : null;
    // System.out.println(rs);



    // int n = 6;
    // int k = 3;
    // Integer[] a = new Integer[n];
    // int count = 0;
    // // int sets = (n*(n-1)*(n-2))/6;
    //
    // for(int i = 0; i< n ;i++){
    // a[i] = i+1;
    // }
    //
    //
    // Integer temp = null;
    // for (int i = 0; i < a.length - 2; i++){
    // for (int j = i + 1; j < a.length - 1; j++){
    // for (int l = j + 1; l < a.length; l++){
    // temp = a[i] + a[j] + a[l];
    // if (temp == k){
    // count ++;
    // }
    // }
    // }
    // }
    //
    // System.out.println(count);

    // Calendar cal = Calendar.getInstance();
    // cal.setTime(new Date());
    // int year = cal.get(Calendar.YEAR);
    // int month = cal.get(Calendar.MONTH);
    // int day = cal.get(Calendar.DAY_OF_MONTH);
    //
    // String yStr = String.valueOf(year);
    // String mStr = String.valueOf(month + 1);
    // String dStr = String.valueOf(day);
    //
    // System.out.println(dStr + "-" + mStr + "-" + yStr);

    // Short shor = 11111;
    // Integer inte = shor.intValue();
    //
    // System.out.println(inte);

    // Student student = new Student();
    // student.setName("name1");
    // student.setIdT(1L);
    // student.setAge(18);
    // analyze(student);
    // StringBuilder rs = new StringBuilder();
    // rs.append("SELECT ");
    // for (int i = 1; i <= 50; i++) {
    // rs.append("applicant.label").append(i).append("_name,\napplicant.label").append(i)
    // .append("_value, ").append("\n");
    // // System.out.println("select applicant.label"+i+"_name, applicant.label"+i+"_value from
    // // applicant, campaign where applicant.cp_id = campaign.id AND campaign.id = '1'");
    // }
    //
    // rs.append("from applicant, campaign where applicant.cp_id = campaign.id AND campaign.id =
    // '1'");
    // System.out.println(rs.toString());
    StringBuilder ss = new StringBuilder();
    // for (int i = 1; i <= 50; i++) {
    // ss.append("\"").append("label").append(i).append("Value").append("\",");
    // System.out.println("private String label" + i + "Name = \"テスト"+i+"NameX\";");
    // System.out.println("private String label" + i + "Value = \"テスト"+i+"ValueY\";");
    // System.out.println("private String label" + i + "Value;");
    // System.out.println("ALTER TABLE applicant DROP COLUMN label" + i + "_name;");

    // System.out.println("label"+i+"_flg int null default 0,");
    // System.out.println("label"+i+"_name character varying(50) null,");
    // System.out.println("label"+i+"_value character varying(50) null,");

    // }
    // System.out.println(ss.toString());
    // for(int i = 1; i<=3;i++) {
    // System.out.println("insert into
    // campaign(id,label1_name,label2_name,label3_name,label4_name,label5_name,label6_name,label7_name,label8_name,label9_name,label10_name)
    // values");
    // }

    Student student = new Student();
    student.setId(1L);
    student.setName("manhnk");
    try {
		System.out.println(ReflectUtils.getValueOf(student, "name"));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//	try {
//		Field field = student.getClass().getField("name");
//		System.out.println(field.get(student));
//		
//	} catch (NoSuchFieldException | SecurityException e) {
//		System.out.println(e.getMessage());
//	}
	


    // System.out.println(test);
    // test.forEach(item -> System.out.println(item));


    // System.out.println("======= END =======");

  }

  public static void analyze(Object obj) {
    ReflectionUtils.doWithFields(obj.getClass(), field -> {

      System.out.println("Field name: " + field.getName());
      field.setAccessible(true);
      System.out.println("Field value: " + field.get(obj));

    });
  }

  private static String getPropertiesType(String input) {
    char[] xxx = input.toCharArray();
    for (int i = 0; i < xxx.length; i++) {
      if (xxx[i] == '_') {
        xxx[i + 1] = Character.toUpperCase(xxx[i + 1]);
      }
    }
    return String.valueOf(xxx).replace("_", "");
  }

  private static Map<String, String> testPutMap() {
    Map<String, String> rs = new HashMap<String, String>();
    rs.put("1", "mot");
    rs.put("2", "hai");
    rs.put("3", "ba");
    rs.put(null, "hihi");

    return rs;
  }

  private static Date checkDateInvalid(String dateString, String dateType) {
    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat(dateType);
    dateFormat.setLenient(false);
    try {
      date = dateFormat.parse(dateString);
    } catch (ParseException e) {
      System.out.println(e.getMessage());
      date = null;
    }

    return date;
  }

  // B1 check null before convert String to Date
  private static boolean isNotBlankStringArr(Integer... integers) {

    for (Integer item : integers) {
      if (Objects.isNull(item)) {
        return false;
      }
    }
    return true;
  }

  // private static String pregReplace(String patternStr, String replacement, String subject) {
  // String rs = null;
  // Pattern pattern = Pattern.compile(patternStr);
  // Matcher matcher = pattern.matcher(subject);
  // if (matcher.find()) {
  // rs = matcher.replaceAll(replacement);
  // }
  // return rs;
  // }

  // private static String replaceMultipleCharacters(String subject, String newChar, String...
  // oldChar) {
  // for (String item : oldChar) {
  // subject = subject.replace(item, newChar);
  // }
  // return subject;
  // }

}
