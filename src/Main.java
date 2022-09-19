public class Main {

    public static void main(String[] args) {

        //DBConnection.createConnection();

        String svar;

        while (true) {

            svar = TerminalInput.getString("Hvad ønsker du? opret/print/slet/update");

            switch (svar){

                case "opret":
                    DBInput.insert();
                    break;

                case "print":
                    DBInput.printBookList();
                    break;

                case "slet":
                    DBInput.delete();
                    break;

                case "update":
                    DBInput.update();
                    break;

                default:
                    System.out.println("indput findes ikke. Prøv igen");


            }
        }
    }


}