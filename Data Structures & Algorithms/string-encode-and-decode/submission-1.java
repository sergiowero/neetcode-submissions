class Solution {

 public String encode(List<String> strs) {

     StringBuilder builder = new StringBuilder();

     for (String s : strs) {

         int length = s.length();

         builder.append(length);
         builder.append('\u001F');
         builder.append(s);

     }

     return builder.toString();
 }

 public List<String> decode(String str) {

    StringBuilder buffer = new StringBuilder();
    List<String> res = new ArrayList<>();
    int size = 0;
    for (char c : str.toCharArray()) {
        if (size > 0) {
            buffer.append(c);
            if (buffer.length() == size) {
                res.add(buffer.toString());
                buffer.setLength(0);
                size = 0;
            }
        } else {
            if (Character.isDigit(c)) {
                buffer.append(c);
            } else if (c == '\u001F') {
                size = Integer.parseInt(buffer.toString());
                buffer.setLength(0);
                if (size == 0) 
                    res.add("");
            }
        }
    }

    return res;
 }

}
