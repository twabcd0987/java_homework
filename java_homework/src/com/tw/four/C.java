package com.tw.four;

public class C {

 /*public static void main(String[] args) {
  String str = "(4+5)*2";
  System.out.println(cacComplex(str));
 }*/

 public  static double cacComplex(String str) {

  if (str.equals(""))
   return 0;
  //System.out.println("CAC:" + str);
  str = str.replaceAll("[\\[\\{]", "(").replaceAll("[\\]\\}]", ")");
  int cl = str.lastIndexOf('(');

  if (cl == -1)
   return cac(str);
  int cr = str.indexOf(')', cl);
  String left = str.substring(0, cl);
  String right = str.substring(cr + 1);
  String middle = str.substring(cl + 1, cr);

  return cacComplex(left + cac(middle) + right);
 }

 public static double cac(String str) {
  if (str.equals(""))
   return 0;

  int ml = str.indexOf('*');
  int dl = str.indexOf('/');

  if (ml == -1 && dl == -1) {
   return cacNoMD(str);
  }
  int index = ml == -1 ? dl : ml;

  // 4+5*6*7+8
  String left = str.substring(0, index);// 4+5
  String m1 = lastNumber(left);
  left = left.substring(0, left.length() - m1.length());
  String right = str.substring(index + 1);// 6*7+8
  String m2 = firstNumber(right);// m2:6
  right = right.substring(m2.length());// *7+8
  double d1 = Double.parseDouble(m1);
  double d2 = Double.parseDouble(m2);
  double tmp = 0;
  if (index == ml) {
   tmp = d1 * d2;
  } else if (index == dl) {
   tmp = d1 / d2;
  }
  return cac(left + tmp + right);

 }

 private static String lastNumber(String str) {
  StringBuilder sb = new StringBuilder();
  for (int i = str.length() - 1; i >= 0; i--) {
   char c = str.charAt(i);
   if (!Character.isDigit(c) && c != '.')
    break;
   sb.append(c);
  }
  return sb.reverse().toString();
 }

 private static String firstNumber(String str) {
  StringBuilder sb = new StringBuilder();
  for (char c : str.toCharArray()) {
   if (!Character.isDigit(c) && c != '.')
    break;
   sb.append(c);
  }
  return sb.toString();
 }

 private static double cacNoMD(String str) {
  double ret = 0;
  StringBuilder sb = new StringBuilder();
  char sign = '+';
  for (char c : (str + "+").toCharArray()) {
   if (!Character.isDigit(c) && c != '.') {
    if (sb.length() == 0)
     continue;
    double tmp = Double.parseDouble(sb.toString());
    if (sign == '+') {
     ret += tmp;
    } else {
     ret -= tmp;
    }
    sb = new StringBuilder();
    sign = c;
   } else {
    sb.append(c);
   }
  }

  return ret;
 }
}