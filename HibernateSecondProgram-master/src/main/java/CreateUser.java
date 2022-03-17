public class CreateUser {
    public static void main(String args[]) {
        if(args.length != 2){
            System.out.println("params required : username, password");
            return;
        }
        String username = args[0];
        String password = args[1];

        try{
            UserDAO userDAO = new UserDAO();
            System.out.println("Creating user " + username);
            userDAO.create(username, password);
            System.out.println("User created!");
            DAO.close();
        }catch (AdException e){
            System.out.println(e.getMessage());
        }
    }
}