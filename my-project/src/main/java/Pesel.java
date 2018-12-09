public class Pesel {

    int[] klasPesel;
    int[] wagi = {9, 7, 3, 1, 9, 7, 3, 1, 9, 7};

    public int generujSume() {
        int suma = 0;
        for (int i = 0; i < klasPesel.length; i++) {
            suma += klasPesel[i] * wagi[i];
        }
        int sumaKontolna = suma % 10;
        return sumaKontolna;
    }

    public String generuj() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < klasPesel.length; i++) {
            sb.append(klasPesel[i]);
        }
        sb.append(generujSume());
        return sb.toString();
    }

    Pesel(int[] parametrPesel) {
        this.klasPesel = parametrPesel;
    }

    int[] convertString(String str){
        char[] arrC = str.toCharArray();
        int[] arrI = new int[arrC.length];
        for (int i = 0; i < arrC.length; i++) {
            arrI[i] = Character.getNumericValue(arrC[i]);
        }
        return arrI;
    }
    /**
     * @param date   = "20120321"
     * @param id     = "012"
     * @param gender = "2"
     */
    Pesel(String date, String id, String gender) {
        int[] dateI = convertString(date);
        int[] idI = convertString(id);
        int genderI = Character.getNumericValue(gender.charAt(0));

        int[] cyfryPesel = new int[10];
        System.arraycopy(dateI, 2, cyfryPesel,0, 6);
        System.arraycopy(idI, 0, cyfryPesel,6, 3);
        cyfryPesel[9] = genderI;

        this.klasPesel = cyfryPesel;
    }

}
