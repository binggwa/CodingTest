package Level1;

public class Level1_13 {
    public String solution(String new_id) {

        String new_id1 = new_id.toLowerCase();
        String new_id2 = new_id1.replaceAll("[^a-z0-9._-]", "");
        String new_id3 = new_id2.replaceAll("\\.{2,}", ".");
        String new_id4 = new_id3.replaceAll("^\\.|\\.$", "");
        if (new_id4.isEmpty()) {
            new_id4 = "a";
        }
        if (new_id4.length() >= 16) {
            new_id4 = new_id4.substring(0, 15);
            new_id4 = new_id4.replaceAll("\\.$", "");
        }
        while (new_id4.length() < 3) {
            new_id4 += new_id4.charAt(new_id4.length() - 1);
        }

        return new_id4;
    }
}
