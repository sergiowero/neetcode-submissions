class Solution {
    public  boolean checkInclusion(String s1, String s2) {

    if (s1.length() > s2.length()) return false;
    Set<Character> set1 = new HashSet<>();
    int[] array1 = new int[27];

    for(var c : s1.toCharArray()) {
        set1.add(c);
        array1[c - 'a']++;
    }

    int l = 0;
    Set<Character> set2 = new HashSet<>(s2.length());
    int[] array2 = new int[27];
    for(int r = 0 ; r < s2.length() ; r++){

        char c = s2.charAt(r);
        set2.add(s2.charAt(r));
        array2[c - 'a']++;
        while (r - l + 1 > s1.length()) { //
            char cc = s2.charAt(l);
            set2.remove(cc);
            array2[cc - 'a']--;
            l++;
        }

        if (r - l + 1 < s1.length()) continue; // grow

        // window size is the same
        // check if list has same elements as list1;
        boolean valid = set1.stream().allMatch(character -> {
            int i = character - 'a';
            return array1[i] == array2[i];
        });

        if (valid) return true;
    }

    return false;

}
}
