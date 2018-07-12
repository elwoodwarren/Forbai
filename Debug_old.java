import java.util.HashMap;
import java.util.Arrays;
import java.util.LinkedList;

public class Debug {
  public static void main(String[] args) {
    HashMap<String, LinkedList<Integer>> countries_Database = new HashMap<String, LinkedList<Integer>>();
    HashMap<String, LinkedList<Integer>> interests_Database = new HashMap<String, LinkedList<Integer>>();
    RedBlackBST<String, String> loginInfo = new RedBlackBST<String, String>();
    RedBlackBST<String, String> userToPass = new RedBlackBST<String, String>();

    countries_Database.put("All", new LinkedList<Integer>());
    countries_Database.put("Afghanistan", new LinkedList<Integer>());
    countries_Database.put("Albania", new LinkedList<Integer>());
    countries_Database.put("Algeria", new LinkedList<Integer>());
    countries_Database.put("Andorra", new LinkedList<Integer>());
    countries_Database.put("Angola", new LinkedList<Integer>());
    countries_Database.put("Anguilla", new LinkedList<Integer>());
    countries_Database.put("Antigua & B.", new LinkedList<Integer>());
    countries_Database.put("Argentina", new LinkedList<Integer>());
    countries_Database.put("Armenia", new LinkedList<Integer>());
    countries_Database.put("Australia", new LinkedList<Integer>());
    countries_Database.put("Austria", new LinkedList<Integer>());
    countries_Database.put("Azerbaijan", new LinkedList<Integer>());
    countries_Database.put("Bahamas", new LinkedList<Integer>());
    countries_Database.put("Bahrain", new LinkedList<Integer>());
    countries_Database.put("Bangladesh", new LinkedList<Integer>());
    countries_Database.put("Barbados", new LinkedList<Integer>());
    countries_Database.put("Belarus", new LinkedList<Integer>());
    countries_Database.put("Belgium", new LinkedList<Integer>());
    countries_Database.put("Belize", new LinkedList<Integer>());
    countries_Database.put("Benin", new LinkedList<Integer>());
    countries_Database.put("Bermuda", new LinkedList<Integer>());
    countries_Database.put("Bhutan", new LinkedList<Integer>());
    countries_Database.put("Bolivia", new LinkedList<Integer>());
    countries_Database.put("Bosnia & H.", new LinkedList<Integer>());
    countries_Database.put("Botswana", new LinkedList<Integer>());
    countries_Database.put("Brazil", new LinkedList<Integer>());
    countries_Database.put("Brunei D.", new LinkedList<Integer>());
    countries_Database.put("Bulgaria", new LinkedList<Integer>());
    countries_Database.put("Burkina Faso", new LinkedList<Integer>());
    countries_Database.put("Myanmar", new LinkedList<Integer>());
    countries_Database.put("Burundi", new LinkedList<Integer>());
    countries_Database.put("Cambodia", new LinkedList<Integer>());
    countries_Database.put("Cameroon", new LinkedList<Integer>());
    countries_Database.put("Canada", new LinkedList<Integer>());
    countries_Database.put("Cape Verde", new LinkedList<Integer>());
    countries_Database.put("Cayman Islands", new LinkedList<Integer>());
    countries_Database.put("Central African Rep.", new LinkedList<Integer>());
    countries_Database.put("Chad", new LinkedList<Integer>());
    countries_Database.put("Chile", new LinkedList<Integer>());
    countries_Database.put("China", new LinkedList<Integer>());
    countries_Database.put("Colombia", new LinkedList<Integer>());
    countries_Database.put("Comoros", new LinkedList<Integer>());
    countries_Database.put("Congo", new LinkedList<Integer>());
    countries_Database.put("Costa Rica", new LinkedList<Integer>());
    countries_Database.put("Croatia", new LinkedList<Integer>());
    countries_Database.put("Cuba", new LinkedList<Integer>());
    countries_Database.put("Cyprus", new LinkedList<Integer>());
    countries_Database.put("Czech Republic", new LinkedList<Integer>());
    countries_Database.put("DR. of the Congo", new LinkedList<Integer>());
    countries_Database.put("Denmark", new LinkedList<Integer>());
    countries_Database.put("Djibouti", new LinkedList<Integer>());
    countries_Database.put("Dominica", new LinkedList<Integer>());
    countries_Database.put("Dominican Republic", new LinkedList<Integer>());
    countries_Database.put("Ecuador", new LinkedList<Integer>());
    countries_Database.put("Egypt", new LinkedList<Integer>());
    countries_Database.put("El Salvador", new LinkedList<Integer>());
    countries_Database.put("Equatorial Guinea", new LinkedList<Integer>());
    countries_Database.put("Eritrea", new LinkedList<Integer>());
    countries_Database.put("Estonia", new LinkedList<Integer>());
    countries_Database.put("Ethiopia", new LinkedList<Integer>());
    countries_Database.put("Fiji", new LinkedList<Integer>());
    countries_Database.put("Finland", new LinkedList<Integer>());
    countries_Database.put("France", new LinkedList<Integer>());
    countries_Database.put("French Guiana", new LinkedList<Integer>());
    countries_Database.put("Gabon", new LinkedList<Integer>());
    countries_Database.put("Gambia", new LinkedList<Integer>());
    countries_Database.put("Georgia", new LinkedList<Integer>());
    countries_Database.put("Germany", new LinkedList<Integer>());
    countries_Database.put("Ghana", new LinkedList<Integer>());
    countries_Database.put("Great Britain", new LinkedList<Integer>());
    countries_Database.put("Greece", new LinkedList<Integer>());
    countries_Database.put("Grenada", new LinkedList<Integer>());
    countries_Database.put("Guadeloupe", new LinkedList<Integer>());
    countries_Database.put("Guatemala", new LinkedList<Integer>());
    countries_Database.put("Guinea", new LinkedList<Integer>());
    countries_Database.put("Guinea-Bissau", new LinkedList<Integer>());
    countries_Database.put("Guyana", new LinkedList<Integer>());
    countries_Database.put("Haiti", new LinkedList<Integer>());
    countries_Database.put("Honduras", new LinkedList<Integer>());
    countries_Database.put("Hungary", new LinkedList<Integer>());
    countries_Database.put("Iceland", new LinkedList<Integer>());
    countries_Database.put("India", new LinkedList<Integer>());
    countries_Database.put("Indonesia", new LinkedList<Integer>());
    countries_Database.put("Iran", new LinkedList<Integer>());
    countries_Database.put("Iraq", new LinkedList<Integer>());
    countries_Database.put("Israel", new LinkedList<Integer>());
    countries_Database.put("Palestine", new LinkedList<Integer>());
    countries_Database.put("Hong Kong", new LinkedList<Integer>());
    countries_Database.put("Taiwan", new LinkedList<Integer>());
    countries_Database.put("Italy", new LinkedList<Integer>());
    countries_Database.put("Ivory Coast", new LinkedList<Integer>());
    countries_Database.put("Jamaica", new LinkedList<Integer>());
    countries_Database.put("Japan", new LinkedList<Integer>());
    countries_Database.put("Jordan", new LinkedList<Integer>());
    countries_Database.put("Kazakhstan", new LinkedList<Integer>());
    countries_Database.put("Kenya", new LinkedList<Integer>());
    countries_Database.put("Kosovo", new LinkedList<Integer>());
    countries_Database.put("Kuwait", new LinkedList<Integer>());
    countries_Database.put("Kyrgyzstan", new LinkedList<Integer>());
    countries_Database.put("Laos", new LinkedList<Integer>());
    countries_Database.put("Latvia", new LinkedList<Integer>());
    countries_Database.put("Lebanon", new LinkedList<Integer>());
    countries_Database.put("Lesotho", new LinkedList<Integer>());
    countries_Database.put("Liberia", new LinkedList<Integer>());
    countries_Database.put("Libya", new LinkedList<Integer>());
    countries_Database.put("Liechtenstein", new LinkedList<Integer>());
    countries_Database.put("Lithuania", new LinkedList<Integer>());
    countries_Database.put("Luxembourg", new LinkedList<Integer>());
    countries_Database.put("Macedonia", new LinkedList<Integer>());
    countries_Database.put("Madagascar", new LinkedList<Integer>());
    countries_Database.put("Malawi", new LinkedList<Integer>());
    countries_Database.put("Malaysia", new LinkedList<Integer>());
    countries_Database.put("Maldives", new LinkedList<Integer>());
    countries_Database.put("Mali", new LinkedList<Integer>());
    countries_Database.put("Malta", new LinkedList<Integer>());
    countries_Database.put("Martinique", new LinkedList<Integer>());
    countries_Database.put("Mauritania", new LinkedList<Integer>());
    countries_Database.put("Mauritius", new LinkedList<Integer>());
    countries_Database.put("Mayotte", new LinkedList<Integer>());
    countries_Database.put("Mexico", new LinkedList<Integer>());
    countries_Database.put("Moldova", new LinkedList<Integer>());
    countries_Database.put("Mongolia", new LinkedList<Integer>());
    countries_Database.put("Montenegro", new LinkedList<Integer>());
    countries_Database.put("Montserrat", new LinkedList<Integer>());
    countries_Database.put("Morocco", new LinkedList<Integer>());
    countries_Database.put("Mozambique", new LinkedList<Integer>());
    countries_Database.put("Namibia", new LinkedList<Integer>());
    countries_Database.put("Nepal", new LinkedList<Integer>());
    countries_Database.put("Netherlands", new LinkedList<Integer>());
    countries_Database.put("New Zealand", new LinkedList<Integer>());
    countries_Database.put("Nicaragua", new LinkedList<Integer>());
    countries_Database.put("Niger", new LinkedList<Integer>());
    countries_Database.put("Nigeria", new LinkedList<Integer>());
    countries_Database.put("North Korea", new LinkedList<Integer>());
    countries_Database.put("Norway", new LinkedList<Integer>());
    countries_Database.put("Oman", new LinkedList<Integer>());
    countries_Database.put("Pacific Islands", new LinkedList<Integer>());
    countries_Database.put("Pakistan", new LinkedList<Integer>());
    countries_Database.put("Panama", new LinkedList<Integer>());
    countries_Database.put("Papua New Guinea", new LinkedList<Integer>());
    countries_Database.put("Paraguay", new LinkedList<Integer>());
    countries_Database.put("Peru", new LinkedList<Integer>());
    countries_Database.put("Philippines", new LinkedList<Integer>());
    countries_Database.put("Poland", new LinkedList<Integer>());
    countries_Database.put("Portugal", new LinkedList<Integer>());
    countries_Database.put("Puerto Rica", new LinkedList<Integer>());
    countries_Database.put("Qatar", new LinkedList<Integer>());
    countries_Database.put("Reunion", new LinkedList<Integer>());
    countries_Database.put("Romania", new LinkedList<Integer>());
    countries_Database.put("Russia", new LinkedList<Integer>());
    countries_Database.put("Rwanda", new LinkedList<Integer>());
    countries_Database.put("Saint Kitts", new LinkedList<Integer>());
    countries_Database.put("Saint Lucia", new LinkedList<Integer>());
    countries_Database.put("Saint Vincent's", new LinkedList<Integer>());
    countries_Database.put("Samoa", new LinkedList<Integer>());
    countries_Database.put("Sao Tome", new LinkedList<Integer>());
    countries_Database.put("Saudi Arabia", new LinkedList<Integer>());
    countries_Database.put("Senegal", new LinkedList<Integer>());
    countries_Database.put("Serbia", new LinkedList<Integer>());
    countries_Database.put("Seychelles", new LinkedList<Integer>());
    countries_Database.put("Sierra Leone", new LinkedList<Integer>());
    countries_Database.put("Singapore", new LinkedList<Integer>());
    countries_Database.put("Slovakia", new LinkedList<Integer>());
    countries_Database.put("Slovenia", new LinkedList<Integer>());
    countries_Database.put("Solomon Islands", new LinkedList<Integer>());
    countries_Database.put("Somalia", new LinkedList<Integer>());
    countries_Database.put("South Africa", new LinkedList<Integer>());
    countries_Database.put("South Korea", new LinkedList<Integer>());
    countries_Database.put("South Sudan", new LinkedList<Integer>());
    countries_Database.put("Spain", new LinkedList<Integer>());
    countries_Database.put("Sri Lanka", new LinkedList<Integer>());
    countries_Database.put("Sudan", new LinkedList<Integer>());
    countries_Database.put("Suriname", new LinkedList<Integer>());
    countries_Database.put("Swaziland", new LinkedList<Integer>());
    countries_Database.put("Sweden", new LinkedList<Integer>());
    countries_Database.put("Switzerland", new LinkedList<Integer>());
    countries_Database.put("Syria", new LinkedList<Integer>());
    countries_Database.put("Tajikistan", new LinkedList<Integer>());
    countries_Database.put("Tanzania", new LinkedList<Integer>());
    countries_Database.put("Thailand", new LinkedList<Integer>());
    countries_Database.put("Timor Leste", new LinkedList<Integer>());
    countries_Database.put("Togo", new LinkedList<Integer>());
    countries_Database.put("Trinidad", new LinkedList<Integer>());
    countries_Database.put("Tunisia", new LinkedList<Integer>());
    countries_Database.put("Turkey", new LinkedList<Integer>());
    countries_Database.put("Turkmenistan", new LinkedList<Integer>());
    countries_Database.put("Turks & Caicos", new LinkedList<Integer>());
    countries_Database.put("Uganda", new LinkedList<Integer>());
    countries_Database.put("Ukraine", new LinkedList<Integer>());
    countries_Database.put("United Arab E.", new LinkedList<Integer>());
    countries_Database.put("USA", new LinkedList<Integer>());
    countries_Database.put("Uruguay", new LinkedList<Integer>());
    countries_Database.put("Uzbekistan", new LinkedList<Integer>());
    countries_Database.put("Venezuela", new LinkedList<Integer>());
    countries_Database.put("Vietnam", new LinkedList<Integer>());
    countries_Database.put("Virgin Islands", new LinkedList<Integer>());
    countries_Database.put("Yemen", new LinkedList<Integer>());
    countries_Database.put("Zambia", new LinkedList<Integer>());
    countries_Database.put("Zimbabwe", new LinkedList<Integer>());

    Account warrenelwood12 = new Account("Warren", "Elwood", "USA", "warren@gmail.com",
                                         "warrenelwood12", "password12", true, new Picture(args[0]), 000000000,
                                         countries_Database, interests_Database, loginInfo, userToPass);
    Account zkyu2 = new Account("Kelvin", "Yu", "China", "kelly@gmail.com",
                                "zkyu2", "kobebryant24", true, new Picture(args[1]), 000000001,
                                countries_Database, interests_Database, loginInfo, userToPass);
    Account nturk12 = new Account("Nick", "Turk", "USA", "nickturk@gmail.com",
                                  "nturk12", "rogerfreder33", true, new Picture(args[0]), 000000002,
                                  countries_Database, interests_Database, loginInfo, userToPass);
    Account lynna_xia = new Account("Hong", "Xia", "China", "blueberry@gmail.com",
                                    "lynna_xia", "password3", false, new Picture(args[1]), 000000003,
                                    countries_Database, interests_Database, loginInfo, userToPass);

    warrenelwood12.addInterest("Food", interests_Database);
    warrenelwood12.addInterest("Fortnite", interests_Database);
    warrenelwood12.addInterest("Lebron James", interests_Database);
    warrenelwood12.addInterest("Drums", interests_Database);
    warrenelwood12.addInterest("Music", interests_Database);
    zkyu2.addInterest("Food", interests_Database);
    zkyu2.addInterest("Culture", interests_Database);
    zkyu2.addInterest("China", interests_Database);
    zkyu2.addInterest("Investing", interests_Database);
    nturk12.addInterest("Music", interests_Database);
    nturk12.addInterest("Food", interests_Database);
    nturk12.addInterest("Fortnite", interests_Database);
    nturk12.addInterest("Tennis", interests_Database);
    lynna_xia.addInterest("Food", interests_Database);
    lynna_xia.addInterest("Music", interests_Database);
    lynna_xia.addInterest("Cooking", interests_Database);
    lynna_xia.addInterest("China", interests_Database);

    Object[] matches0 = Search.search("All", "Food", countries_Database, interests_Database);                       // test Search, deletes matches from hashmap
    Object[] matches1 = Search.search("USA", "Music", countries_Database, interests_Database);
    Object[] matches2 = Search.search("All", "Basketball", countries_Database, interests_Database);
    Object[] matches3 = Search.search("China", "Fortnite", countries_Database, interests_Database);

    System.out.println("All countries, food interest: " + Arrays.toString(matches0));                               // prints all accounts w/ food interest (all)
    System.out.println("USA, music interest: " + Arrays.toString(matches1));                                        // prints USA accounts w/ music interest (w + n)
    System.out.println("All countries, basketball interests: " + Arrays.toString(matches2));                        // prints all accounts w/ bball interest (none)
    System.out.println("China, Fortnite interests: " + Arrays.toString(matches3));                                   // prints China accounts w/ Fortnite interest (none)

    System.out.println("All accounts: " + Account.toCountryString("All", countries_Database));                      // prints all accounts
    System.out.println("USA accounts: " + Account.toCountryString("USA", countries_Database));                      // prints all USA accounts (w + n)
    System.out.println("China interest accounts: " + Account.toInterestString("China", interests_Database));        // prints all China interest accounts (k + m)
    System.out.println("Investing interest accounts: " + Account.toInterestString("Investing", interests_Database));// prints all Investing interest accounts (k)

    System.out.println("Warren interests: " + Arrays.toString(warrenelwood12.interestList()));                      // prints all of Warren's OG interests
    System.out.println("Kelvin interests: " + Arrays.toString(zkyu2.interestList()));                               // prints all of Kelvin's OG interests
    System.out.println("Turk's interests: " + Arrays.toString(nturk12.interestList()));                             // prints all of Nick's OG interests
    System.out.println("Mom's interests: " + Arrays.toString(lynna_xia.interestList()));                            // prints all of Mom's OG interests

    // update interests
    warrenelwood12.removeInterest("Food", interests_Database);
    warrenelwood12.removeInterest("Music", interests_Database);
    warrenelwood12.removeInterest("Drums", interests_Database);
    warrenelwood12.removeInterest("Lebron James", interests_Database);
    warrenelwood12.removeInterest("Fortnite", interests_Database);
    zkyu2.removeInterest("Food", interests_Database);
    nturk12.removeInterest("Food", interests_Database);
    lynna_xia.removeInterest("Food", interests_Database);

    Object[] matches4 = Search.search("All", "Food", countries_Database, interests_Database);                       // test Search w/updated interests
    Object[] matches5 = Search.search("USA", "Music", countries_Database, interests_Database);
    Object[] matches6 = Search.search("USA", "Fortnite", countries_Database, interests_Database);
    Object[] matches7 = Search.search("China", "Food", countries_Database, interests_Database);

    System.out.println("All countries, food interest: " + Arrays.toString(matches4));                               // prints all accounts w/ food interest (none)
    System.out.println("USA, music interest: " + Arrays.toString(matches5));                                        // prints USA accounts w/ music interest (n)
    System.out.println("USA, Fortnite interests: " + Arrays.toString(matches6));                                    // prints USA accounts w/ Fortnite interest (n)
    System.out.println("China, food interests: " + Arrays.toString(matches7));                                      // prints China accounts w/ food interest (none)

    System.out.println("All accounts: " + Account.toCountryString("All", countries_Database));                      // prints all accounts
    System.out.println("USA accounts: " + Account.toCountryString("USA", countries_Database));                      // prints all USA accounts (w + n)
    System.out.println("China interest accounts: " + Account.toInterestString("China", interests_Database));        // prints all China interest accounts (k + m)
    System.out.println("Investing interest accounts: " + Account.toInterestString("Investing", interests_Database));    // prints all Investing interest accounts (k)

    System.out.println("Warren interests: " + Arrays.toString(warrenelwood12.interestList()));                      // prints all of Warren's updated interests
    System.out.println("Kelvin interests: " + Arrays.toString(zkyu2.interestList()));                               // prints all of Kelvin's updated interests
    System.out.println("Turk's interests: " + Arrays.toString(nturk12.interestList()));                             // prints all of Nick's updated interests
    System.out.println("Mom's interests: " + Arrays.toString(lynna_xia.interestList()));                            // prints all of Mom's updated interests

    System.out.println("Warren's username is: " + warrenelwood12.showUser());                                       // warrenelwood12
    System.out.println("Warren's password is: " + warrenelwood12.showPass());                                       // password12
    System.out.println("Mom's email is: " + lynna_xia.showEmail());                                                 // blueberry@gmail.com

    zkyu2.changeUsername("labron", userToPass);
    nturk12.changePassword("nickthefrick", loginInfo, userToPass);
    warrenelwood12.changeEmail("weee@uo.com", loginInfo);

    System.out.println("Kelvin's username is: " + zkyu2.showUser());                                                // labron
    System.out.println("Nick's password is: " + nturk12.showPass());                                                // nickthefrick
    System.out.println("Warren's email is: " + warrenelwood12.showEmail());                                         // weee@uo.com
  }
}