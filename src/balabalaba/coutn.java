package balabalaba;

public class coutn {
	public static void main(String []args) {
		System.out.println(replace("AAAABLAHblah", "blah", "ha"));
	}
		public static String replace(String str, String searchStr, String replaceStr) {
			if(str.toLowerCase().indexOf(searchStr.toLowerCase()) == -1) {
				return str;
			}
			return str.substring(0,str.toLowerCase().indexOf(searchStr.toLowerCase())) + replaceStr + replace(str.substring(str.toLowerCase().indexOf(searchStr.toLowerCase())+searchStr.length()), searchStr, replaceStr);
			
		}
	}

