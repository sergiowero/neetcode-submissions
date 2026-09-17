class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<List<Integer>, List<String>> map = new HashMap<>();

        for (String s : strs) {

            List<Integer> freqs = newList();

            for (char c : s.toCharArray()) {
                int index = c - 'a';
                freqs.set(index, freqs.get(index) + 1);
            }

            if (map.containsKey(freqs)) {
                map.get(freqs).add(s);
            } else {
                var list = new ArrayList<String>();
                list.add(s);
                map.put(freqs, list);
            }

        }

        return map.values().stream().toList();

    }

    private List<Integer> newList() {
        return new ArrayList<>(Collections.nCopies(26, 0));
    }
}
