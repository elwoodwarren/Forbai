import java.util.HashMap;
import java.util.Arrays;
import java.util.LinkedList;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public class Debug {
    public static void main(String[] args) {

        // Creating the necessary data structures for WeSpeak
        HashMap<String, LinkedList<Integer>> countries_Database = new HashMap<String, LinkedList<Integer>>();           // maps a country to all account IDs in that country
        HashMap<String, LinkedList<Integer>> interests_Database = new HashMap<String, LinkedList<Integer>>();           // maps an interest to all the account IDs with that interest
        HashMap<String, String> loginInfo = new HashMap<String, String>();                                              // maps a user's email to their password
        HashMap<String, Integer> userToID = new HashMap<String, Integer>();                                             // maps a user's username to their ID
        HashMap<Integer, Account> idToAcc = new HashMap<Integer, Account>();                                            // maps a user's ID to the corresponding Account object
        HashMap<Integer, LinkedList<Integer>> idToEmbraceeIDs = new HashMap<Integer, LinkedList<Integer>>();            // maps a user's ID to their embracees' IDs
        HashMap<String, LinkedList<GroupChat>> topicToChats = new HashMap<String, LinkedList<GroupChat>>();             // maps topics to the corresponding Groupchats
        HashMap<String, LinkedList<GroupChat>> ambassadorChats = new HashMap<String, LinkedList<GroupChat>>();          // same thing as topicToChats except ambassador chats only
        HashMap<Integer, LinkedList<Post>> idToPosts = new HashMap<Integer, LinkedList<Post>>();                        // maps a user's ID to their embracees' Sonder posts

        LinkedList<String> countries = new LinkedList<String>();                                                        // Since hashmaps are not sorted, front-end will need
        LinkedList<String> topics = new LinkedList<String>();                                                           // a list of sorted countries and topics

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
        countries_Database.put("United Kingdom", new LinkedList<Integer>());
        countries_Database.put("USA", new LinkedList<Integer>());
        countries_Database.put("Uruguay", new LinkedList<Integer>());
        countries_Database.put("Uzbekistan", new LinkedList<Integer>());
        countries_Database.put("Venezuela", new LinkedList<Integer>());
        countries_Database.put("Vietnam", new LinkedList<Integer>());
        countries_Database.put("Virgin Islands", new LinkedList<Integer>());
        countries_Database.put("Yemen", new LinkedList<Integer>());
        countries_Database.put("Zambia", new LinkedList<Integer>());
        countries_Database.put("Zimbabwe", new LinkedList<Integer>());

        topicToChats.put("All", new LinkedList<GroupChat>());
        topicToChats.put("Art", new LinkedList<GroupChat>());
        topicToChats.put("Career", new LinkedList<GroupChat>());
        topicToChats.put("Culture", new LinkedList<GroupChat>());
        topicToChats.put("Economy", new LinkedList<GroupChat>());
        topicToChats.put("Education", new LinkedList<GroupChat>());
        topicToChats.put("Entertainment", new LinkedList<GroupChat>());
        topicToChats.put("Fashion", new LinkedList<GroupChat>());
        topicToChats.put("Finance", new LinkedList<GroupChat>());
        topicToChats.put("Food and Drink", new LinkedList<GroupChat>());
        topicToChats.put("Health", new LinkedList<GroupChat>());
        topicToChats.put("History", new LinkedList<GroupChat>());
        topicToChats.put("Other", new LinkedList<GroupChat>());
        topicToChats.put("Music", new LinkedList<GroupChat>());
        topicToChats.put("Nature", new LinkedList<GroupChat>());
        topicToChats.put("News", new LinkedList<GroupChat>());
        topicToChats.put("People", new LinkedList<GroupChat>());
        topicToChats.put("Politics", new LinkedList<GroupChat>());
        topicToChats.put("Philosophy", new LinkedList<GroupChat>());
        topicToChats.put("Religion", new LinkedList<GroupChat>());
        topicToChats.put("Science/Tech", new LinkedList<GroupChat>());
        topicToChats.put("Society", new LinkedList<GroupChat>());
        topicToChats.put("Sports", new LinkedList<GroupChat>());
        topicToChats.put("Travel", new LinkedList<GroupChat>());

        ambassadorChats.put("All", new LinkedList<GroupChat>());
        ambassadorChats.put("Art", new LinkedList<GroupChat>());
        ambassadorChats.put("Career", new LinkedList<GroupChat>());
        ambassadorChats.put("Culture", new LinkedList<GroupChat>());
        ambassadorChats.put("Economy", new LinkedList<GroupChat>());
        ambassadorChats.put("Education", new LinkedList<GroupChat>());
        ambassadorChats.put("Entertainment", new LinkedList<GroupChat>());
        ambassadorChats.put("Fashion", new LinkedList<GroupChat>());
        ambassadorChats.put("Finance", new LinkedList<GroupChat>());
        ambassadorChats.put("Food and Drink", new LinkedList<GroupChat>());
        ambassadorChats.put("Health", new LinkedList<GroupChat>());
        ambassadorChats.put("History", new LinkedList<GroupChat>());
        ambassadorChats.put("Other", new LinkedList<GroupChat>());
        ambassadorChats.put("Music", new LinkedList<GroupChat>());
        ambassadorChats.put("Nature", new LinkedList<GroupChat>());
        ambassadorChats.put("News", new LinkedList<GroupChat>());
        ambassadorChats.put("People", new LinkedList<GroupChat>());
        ambassadorChats.put("Politics", new LinkedList<GroupChat>());
        ambassadorChats.put("Philosophy", new LinkedList<GroupChat>());
        ambassadorChats.put("Religion", new LinkedList<GroupChat>());
        ambassadorChats.put("Science/Tech", new LinkedList<GroupChat>());
        ambassadorChats.put("Society", new LinkedList<GroupChat>());
        ambassadorChats.put("Sports", new LinkedList<GroupChat>());
        ambassadorChats.put("Travel", new LinkedList<GroupChat>());

        /*
        countries.add("All");
        countries.add("Afghanistan");
        countries.add("Albania");
        countries.add("Algeria");
        countries.add("Andorra");
        countries.add("Angola");
        countries.add("Anguilla");
        countries.add("Antigua & B.");
        countries.add("Argentina");
        countries.add("Armenia");
        countries.add("Australia");
        countries.add("Austria");
        countries.add("Azerbaijan");
        countries.add("Bahamas");
        countries.add("Bahrain");
        countries.add("Bangladesh");
        countries.add("Barbados");
        countries.add("Belarus");
        countries.add("Belgium");
        countries.add("Belize");
        countries.add("Benin");
        countries.add("Bermuda");
        countries.add("Bhutan");
        countries.add("Bolivia");
        countries.add("Bosnia & H.");
        countries.add("Botswana");
        countries.add("Brazil");
        countries.add("Brunei D.");
        countries.add("Bulgaria");
        countries.add("Burkina Faso");
        countries.add("Myanmar");
        countries.add("Burundi");
        countries.add("Cambodia");
        countries.add("Cameroon");
        countries.add("Canada");
        countries.add("Cape Verde");
        countries.add("Cayman Islands");
        countries.add("Central African Rep.");
        countries.add("Chad");
        countries.add("Chile");
        countries.add("China");
        countries.add("Colombia");
        countries.add("Comoros");
        countries.add("Congo");
        countries.add("Costa Rica");
        countries.add("Croatia");
        countries.add("Cuba");
        countries.add("Cyprus");
        countries.add("Czech Republic");
        countries.add("DR. of the Congo");
        countries.add("Denmark");
        countries.add("Djibouti");
        countries.add("Dominica");
        countries.add("Dominican Republic");
        countries.add("Ecuador");
        countries.add("Egypt");
        countries.add("El Salvador");
        countries.add("Equatorial Guinea");
        countries.add("Eritrea");
        countries.add("Estonia");
        countries.add("Ethiopia");
        countries.add("Fiji");
        countries.add("Finland");
        countries.add("France");
        countries.add("French Guiana");
        countries.add("Gabon");
        countries.add("Gambia");
        countries.add("Georgia");
        countries.add("Germany");
        countries.add("Ghana");
        countries.add("Great Britain");
        countries.add("Greece");
        countries.add("Grenada");
        countries.add("Guadeloupe");
        countries.add("Guatemala");
        countries.add("Guinea");
        countries.add("Guinea-Bissau");
        countries.add("Guyana");
        countries.add("Haiti");
        countries.add("Honduras");
        countries.add("Hungary");
        countries.add("Iceland");
        countries.add("India");
        countries.add("Indonesia");
        countries.add("Iran");
        countries.add("Iraq");
        countries.add("Israel");
        countries.add("Palestine");
        countries.add("Hong Kong");
        countries.add("Taiwan");
        countries.add("Italy");
        countries.add("Ivory Coast");
        countries.add("Jamaica");
        countries.add("Japan");
        countries.add("Jordan");
        countries.add("Kazakhstan");
        countries.add("Kenya");
        countries.add("Kosovo");
        countries.add("Kuwait");
        countries.add("Kyrgyzstan");
        countries.add("Laos");
        countries.add("Latvia");
        countries.add("Lebanon");
        countries.add("Lesotho");
        countries.add("Liberia");
        countries.add("Libya");
        countries.add("Liechtenstein");
        countries.add("Lithuania");
        countries.add("Luxembourg");
        countries.add("Macedonia");
        countries.add("Madagascar");
        countries.add("Malawi");
        countries.add("Malaysia");
        countries.add("Maldives");
        countries.add("Mali");
        countries.add("Malta");
        countries.add("Martinique");
        countries.add("Mauritania");
        countries.add("Mauritius");
        countries.add("Mayotte");
        countries.add("Mexico");
        countries.add("Moldova");
        countries.add("Mongolia");
        countries.add("Montenegro");
        countries.add("Montserrat");
        countries.add("Morocco");
        countries.add("Mozambique");
        countries.add("Namibia");
        countries.add("Nepal");
        countries.add("Netherlands");
        countries.add("New Zealand");
        countries.add("Nicaragua");
        countries.add("Niger");
        countries.add("Nigeria");
        countries.add("North Korea");
        countries.add("Norway");
        countries.add("Oman");
        countries.add("Pacific Islands");
        countries.add("Pakistan");
        countries.add("Panama");
        countries.add("Papua New Guinea");
        countries.add("Paraguay");
        countries.add("Peru");
        countries.add("Philippines");
        countries.add("Poland");
        countries.add("Portugal");
        countries.add("Puerto Rica");
        countries.add("Qatar");
        countries.add("Reunion");
        countries.add("Romania");
        countries.add("Russia");
        countries.add("Rwanda");
        countries.add("Saint Kitts");
        countries.add("Saint Lucia");
        countries.add("Saint Vincent's");
        countries.add("Samoa");
        countries.add("Sao Tome");
        countries.add("Saudi Arabia");
        countries.add("Senegal");
        countries.add("Serbia");
        countries.add("Seychelles");
        countries.add("Sierra Leone");
        countries.add("Singapore");
        countries.add("Slovakia");
        countries.add("Slovenia");
        countries.add("Solomon Islands");
        countries.add("Somalia");
        countries.add("South Africa");
        countries.add("South Korea");
        countries.add("South Sudan");
        countries.add("Spain");
        countries.add("Sri Lanka");
        countries.add("Sudan");
        countries.add("Suriname");
        countries.add("Swaziland");
        countries.add("Sweden");
        countries.add("Switzerland");
        countries.add("Syria");
        countries.add("Tajikistan");
        countries.add("Tanzania");
        countries.add("Thailand");
        countries.add("Timor Leste");
        countries.add("Togo");
        countries.add("Trinidad");
        countries.add("Tunisia");
        countries.add("Turkey");
        countries.add("Turkmenistan");
        countries.add("Turks & Caicos");
        countries.add("Uganda");
        countries.add("Ukraine");
        countries.add("United Arab E.");
        countries.add("United Kingdom");
        countries.add("USA");
        countries.add("Uruguay");
        countries.add("Uzbekistan");
        countries.add("Venezuela");
        countries.add("Vietnam");
        countries.add("Virgin Islands");
        countries.add("Yemen");
        countries.add("Zambia");
        countries.add("Zimbabwe");

        topics.add("All");
        topics.add("Art");
        topics.add("Career");
        topics.add("Culture");
        topics.add("Economy");
        topics.add("Education");
        topics.add("Entertainment");
        topics.add("Fashion");
        topics.add("Finance");
        topics.add("Food and Drink");
        topics.add("Health");
        topics.add("History");
        topics.add("Other");
        topics.add("Music");
        topics.add("Nature");
        topics.add("News");
        topics.add("People");
        topics.add("Politics");
        topics.add("Philosophy");
        topics.add("Religion");
        topics.add("Science/Tech");
        topics.add("Society");
        topics.add("Sports");
        topics.add("Travel");
        */

        // TESTS SEARCH, ACCOUNT CREATION, & ADDING/REMOVING INTERESTS

        Account.create("Warren", "Elwood", 19, "USA", "warren@gmail.com", "warrenelwood12", "kobepop", true, new Picture(args[0]),
        countries_Database, interests_Database, loginInfo, userToID, idToAcc);
        Account.create("Kelvin", "Yu", 19, "China", "kelly@gmail.com", "zkyu2", "lebronkobe", true, new Picture(args[1]),
        countries_Database, interests_Database, loginInfo, userToID, idToAcc);
        Account.create("Nick", "Turk", 20, "USA", "nickturk@gmail.com", "nturk12", "nikeadidas", true, new Picture(args[0]),
        countries_Database, interests_Database, loginInfo, userToID, idToAcc);
        Account.create("Hong", "Xia", 50, "China", "blueberry@gmail.com", "lynna_xia", "helloworld", false, new Picture(args[1]),
        countries_Database, interests_Database, loginInfo, userToID, idToAcc);

        Account.addInterest(0, "The Food", interests_Database, idToAcc);
        Account.addInterest(0, "The Fortnite", interests_Database, idToAcc);
        Account.addInterest(0, "The Lebron James", interests_Database, idToAcc);
        Account.addInterest(0, "The Drums", interests_Database, idToAcc);
        Account.addInterest(0, "Music", interests_Database, idToAcc);
        Account.addInterest(1, "Food", interests_Database, idToAcc);
        Account.addInterest(1, "The Culture", interests_Database, idToAcc);
        Account.addInterest(1, "China", interests_Database, idToAcc);
        Account.addInterest(1, "Investing", interests_Database, idToAcc);
        Account.addInterest(2, "Music", interests_Database, idToAcc);
        Account.addInterest(2, "Food", interests_Database, idToAcc);
        Account.addInterest(2, "Fortnite", interests_Database, idToAcc);
        Account.addInterest(2, "Tennis", interests_Database, idToAcc);
        Account.addInterest(3, "China", interests_Database, idToAcc);
        Account.addInterest(3, "Music", interests_Database, idToAcc);
        Account.addInterest(3, "Cooking", interests_Database, idToAcc);

        Object[] matches0 = Search.search("All", "Food", countries_Database, interests_Database);                       // test Search
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

        System.out.println("Warren interests: " + Arrays.toString(Account.interestList(0, idToAcc)));                      // prints all of Warren's OG interests
        System.out.println("Kelvin interests: " + Arrays.toString(Account.interestList(1, idToAcc)));                               // prints all of Kelvin's OG interests
        System.out.println("Turk's interests: " + Arrays.toString(Account.interestList(2, idToAcc)));                             // prints all of Nick's OG interests
        System.out.println("Mom's interests: " + Arrays.toString(Account.interestList(3, idToAcc)));                            // prints all of Mom's OG interests

        // update interests
        Account.removeInterest(0, "Food", interests_Database, idToAcc);
        Account.removeInterest(0,"Music", interests_Database, idToAcc);
        Account.removeInterest(0,"Drums", interests_Database, idToAcc);
        Account.removeInterest(0,"Lebron James", interests_Database, idToAcc);
        Account.removeInterest(0,"Fortnite", interests_Database, idToAcc);
        Account.removeInterest(1,"Food", interests_Database, idToAcc);
        Account.removeInterest(2,"Food", interests_Database, idToAcc);
        Account.removeInterest(3,"Food", interests_Database, idToAcc);

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
        System.out.println("Investing interest accounts: " + Account.toInterestString("Investing", interests_Database));// prints all Investing interest accounts (k)

        System.out.println("Warren interests: " + Arrays.toString(Account.interestList(0, idToAcc)));               // prints all of Warren's updated interests
        System.out.println("Kelvin interests: " + Arrays.toString(Account.interestList(1, idToAcc)));               // prints all of Kelvin's updated interests
        System.out.println("Turk's interests: " + Arrays.toString(Account.interestList(2, idToAcc)));               // prints all of Nick's updated interests
        System.out.println("Mom's interests: " + Arrays.toString(Account.interestList(3, idToAcc)));                // prints all of Mom's updated interests

        System.out.println("Warren's username is: " + Account.showUser(0, idToAcc));                                // warrenelwood12
        System.out.println("Warren's password is: " + Account.showPass(0, idToAcc));                                // password12
        System.out.println("Mom's email is: " + Account.showEmail(3, idToAcc));                                     // blueberry@gmail.com

        // TESTS CHANGING ACCOUNT INFO

        Account.changeUsername(1, "labron", userToID, idToAcc);
        Account.changePassword(3, "nickthefrick", loginInfo, idToAcc);
        Account.changeEmail(0, "weee@uo.com", loginInfo, idToAcc);
        Account.makeAmbassador(1, idToAcc);

        System.out.println("Kelvin's username is: " + Account.showUser(1, idToAcc));                                // labron
        System.out.println("Nick's password is: " + Account.showPass(2, idToAcc));                                  // nickthefrick
        System.out.println("Warren's email is: " + Account.showEmail(0, idToAcc));                                  // weee@uo.com

        Account.addInterest(2, "Hello Kitty", interests_Database, idToAcc);
        System.out.println("Nick's interests: " + Arrays.toString(Account.interestList(2, idToAcc)));               // tests if interest is inserted at correct spot

        // TESTS CHATS/MESSAGES
        IndividualChat indChat0 = new IndividualChat(0, 1, idToAcc);

        indChat0.addMessage("Hey", null, null, 0);
        indChat0.addMessage("Yo whats up?", null, null, 1);
        indChat0.addMessage("You like basketball?", null, null, 0);
        indChat0.addMessage("Course bro", null, null, 1);
        indChat0.addMessage("LEBRON TO LAKERS", null, null, 0);
        indChat0.addMessage("Flex on em boiiii", null, null, 1);

        Queue<IndividualChat.Message> chatHis0 = indChat0.history();
        for (IndividualChat.Message m : chatHis0) {
            System.out.println(m.toVisual());                                                                          // prints all messages in indChat0
        }

        GroupChat groupChat0 = new GroupChat(1, "Politics", "Is Trump a good president?", topicToChats, ambassadorChats, idToAcc);
        groupChat0.addUser(0, idToAcc);
        groupChat0.addUser(2, idToAcc);
        groupChat0.addUser(3, idToAcc);
        groupChat0.removeUser(2, idToAcc, topicToChats, ambassadorChats);

        groupChat0.addMessage("Do y'all like Donald Trump?", null, null, 0, idToAcc);
        groupChat0.addMessage("What's wrong with him?", null, null, 1, idToAcc);
        groupChat0.addMessage("He's a clown?", null, null, 2, idToAcc);
        groupChat0.addMessage("You cray", null, null, 3, idToAcc);
        groupChat0.addMessage("Yeah I like him", null, null, 0, idToAcc);
        groupChat0.addMessage("Homie are you dumb", null, null, 3, idToAcc);

        Queue<GroupChat.Message> chatHis1 = groupChat0.history();
        for (GroupChat.Message m : chatHis1) {
            System.out.println(m.toVisual());                                                                          // prints all messages in groupChat0
        }

        LinkedList<GroupChat> momChats = Account.allGroupChats(3, idToAcc);
        for (GroupChat chat : momChats) {
            for (GroupChat.Message m : chat.history())                                                                  // prints all messages in the chats associated with mom's account
            System.out.println(m.toVisual());
        }

        LinkedList<IndividualChat> kelvinChats = Account.allIndChats(1, idToAcc);
        for (IndividualChat chat : kelvinChats) {
            for (IndividualChat.Message m : chat.history())                                                             // prints all messages in the chats associated with kelvin's account
            System.out.println(m.toVisual());
        }

        for (Object user : indChat0.showUsers())
        System.out.print(user + " ");                                                                                   // prints all users in indChat0 (0, 1)
        System.out.println();
        for (Object user : groupChat0.showUsers())
        System.out.print(user + " ");                                                                                   // prints all users in groupChat0 (0, 1, 3)
        System.out.println();

        // TEST DISCUSSION SEARCH
        GroupChat groupChat1 = new GroupChat(1, "Politics", "I love Barack Obama.", topicToChats, ambassadorChats, idToAcc);
        GroupChat groupChat2 = new GroupChat(2, "Politics", "I hate Donald Trump!", topicToChats, ambassadorChats, idToAcc);
        GroupChat groupChat3 = new GroupChat(1, "Science/Tech", "What is quantum physics?", topicToChats, ambassadorChats, idToAcc);
        GroupChat groupChat4 = new GroupChat(0, "Music", "I love Kendrick", topicToChats, ambassadorChats, idToAcc);
        GroupChat groupChat5 = new GroupChat(1, "Other", "I love nice people.", topicToChats, ambassadorChats, idToAcc);
        GroupChat groupChat6 = new GroupChat(2, "Politics", "Is Trump a bad president?", topicToChats, ambassadorChats, idToAcc);
        GroupChat groupChat7 = new GroupChat(3, "Food and Drink", "I love food.", topicToChats, ambassadorChats, idToAcc);
        GroupChat groupChat8 = new GroupChat(1, "Career", "Private equity is fun.", topicToChats, ambassadorChats, idToAcc);
        GroupChat groupChat9 = new GroupChat(0, "Economy", "Venture capital is fun.", topicToChats, ambassadorChats, idToAcc);
        GroupChat.deleteChat(groupChat5, topicToChats, ambassadorChats);
        groupChat1.removeUser(1, idToAcc, topicToChats, ambassadorChats);

        Queue<GroupChat> matches8 = SearchDiscussions.search("Politics", topicToChats);
        Queue<GroupChat> matches9 = SearchDiscussions.search("Science/Tech", topicToChats);
        Queue<GroupChat> matches10 = SearchDiscussions.search("Other", topicToChats);
        Queue<GroupChat> matches11 = SearchDiscussions.search("All", topicToChats);

        System.out.println("Politics chats : ");
        for (GroupChat gc : matches8)
        System.out.println(gc.showTitle());


        System.out.println("Science/Tech chats: ");
        for (GroupChat gc : matches9)
        System.out.println(gc.showTitle());

        System.out.println("Other chats: ");
        for (GroupChat gc : matches10)
        System.out.println(gc.showTitle());

        System.out.println("All chats: ");
        for (GroupChat gc : matches11)
        System.out.println(gc.showTitle());

        // test showing Ambassador chats (only Kelvin (id = 1 is an ambassador))
        LinkedList<GroupChat> ambChats1 = ambassadorChats.get("All");
        LinkedList<GroupChat> ambChats2 = ambassadorChats.get("Politics");

        System.out.println("Ambassador 'All' Chats: ");
        for (GroupChat gc : ambChats1)
        System.out.println(gc.showTitle());

        System.out.println("Ambassador 'Politics' Chats: ");
        for (GroupChat gc : ambChats2)
        System.out.println(gc.showTitle());

        // TESTS EMBRACING PEOPLE
        Account.sendEmbrace(0, 1, idToAcc);
        Account.acceptEmbrace(1, 0, idToEmbraceeIDs, idToAcc);
        System.out.println("Warren's embracees are: ");
        for (int accID : Account.showEmbracees(0, idToEmbraceeIDs))
        System.out.println(accID);                                                                                      // prints all of Warren's embracees (1)
        System.out.println("Kelvin's embracees are: ");
        for (int accID : Account.showEmbracees(1, idToEmbraceeIDs))
        System.out.println(accID);                                                                                      // prints all of Kelvin's embracees (0)

        Account.sendEmbrace(2, 0, idToAcc);
        Account.acceptEmbrace(0, 2, idToEmbraceeIDs, idToAcc);
        System.out.println("Warren's embracees are: ");
        for (int accID : Account.showEmbracees(0, idToEmbraceeIDs))
        System.out.println(accID);                                                                                      // prints all of Warren's embracees (1, 2)
        System.out.println("Nick's embracees are ");
        for (int accID : Account.showEmbracees(2, idToEmbraceeIDs))
        System.out.println(accID);                                                                                      // prints all of Nick's embracees (0)

        Account.sendEmbrace(1, 3, idToAcc);
        Account.sendEmbrace(2, 3, idToAcc);
        System.out.println("Mom's embracee requests are ");
        for (int accID: Account.showEmbraceRequests(3, idToAcc))
        System.out.println(accID);                                                                                      // prints of all Mom's embrace requests (1, 2)
        Account.removeEmbraceRequest(3, 2, idToAcc);
        System.out.println("Mom's new embracee requests are ");
        for (int accID: Account.showEmbraceRequests(3, idToAcc))
        System.out.println(accID);                                                                                      // prints Mom's new embrace requests (1)

        Account.acceptEmbrace(3, 1, idToEmbraceeIDs, idToAcc);
        System.out.println("Kelvin's embracees are: ");
        for (int accID : Account.showEmbracees(1, idToEmbraceeIDs))
        System.out.println(accID);                                                                                      // prints all of Kelvin's embracees (0, 3)
        System.out.println("Mom's embracees are: ");
        for (int accID : Account.showEmbracees(3, idToEmbraceeIDs))
        System.out.println(accID);                                                                                      // prints all of Mom's embracees (1)

        Account.sendEmbrace(2, 1, idToAcc);
        Account.acceptEmbrace(1, 2, idToEmbraceeIDs, idToAcc);
        System.out.println("Kelvin's embracees are: ");
        for (int accID : Account.showEmbracees(1, idToEmbraceeIDs))
        System.out.println(accID);                                                                                      // prints all of Kelvin's embracees (0, 2, 3)
        System.out.println("Nick's embracees are: ");
        for (int accID : Account.showEmbracees(2, idToEmbraceeIDs))                                                     // prints all of Nick's embracees (0, 1)
        System.out.println(accID);

        Account.removeEmbracee(0, 1, idToEmbraceeIDs, idToAcc);
        Account.removeEmbracee(1, 2, idToEmbraceeIDs, idToAcc);
        Account.removeEmbracee(3, 1, idToEmbraceeIDs, idToAcc);

        System.out.println("Warren's embracees are: ");
        for (int accID : Account.showEmbracees(0, idToEmbraceeIDs))
        System.out.println(accID);                                                                                      // prints all of Warren's embracees (2)
        System.out.println("Kelvin's embracees are: ");
        for (int accID : Account.showEmbracees(1, idToEmbraceeIDs))
        System.out.println(accID);                                                                                      // prints all of Kelvin's embracees (none)
        System.out.println("Nick's embracees are: ");
        for (int accID : Account.showEmbracees(2, idToEmbraceeIDs))
        System.out.println(accID);                                                                                      // prints all of Nick's embracees (0)
        System.out.println("Mom's embracees are: ");
        for (int accID : Account.showEmbracees(3, idToEmbraceeIDs))
        System.out.println(accID);                                                                                      // prints all of Mom's embracees (none)

        System.out.println("Warren's embrace requests: ");
        for (int accID: Account.showEmbraceRequests(0, idToAcc))                                                        // (none)
        System.out.println(accID);

        // TEST REPORTING
        Account.report(0, "They're trolling", idToAcc);
        Account.report(1, "Spam account", idToAcc);
        Account.report(0, "They're extremely rude", idToAcc);
        System.out.println("Warren has " + Account.reportNum(0, idToAcc) + " reports");
        System.out.println("Kelvin has " + Account.reportNum(1, idToAcc) + " reports");

        // tests misc methods that I added
        System.out.println(Account.getNumberOfInterests(1, idToAcc));                                                   // 3
        System.out.println(Account.getNumberOfChats(1, idToAcc));                                                       // 10
        System.out.println(groupChat0.showAdmin());                                                                      // 1

        // TEST POST.java
        Post warrenUpdate0 = new Post("My dogs hate my cats.", null, null, 0, null, idToPosts, idToEmbraceeIDs);
        Post kelvinUpdate0 = new Post("I like girls.", null, null, 1, null, idToPosts, idToEmbraceeIDs);
        Post nickUpdate0 = new Post("I am good at tennis.", null, null, 2, null, idToPosts, idToEmbraceeIDs);
        Post momUpdate0 = new Post("I like to cook Chinese food.", null, null, 3, null, idToPosts, idToEmbraceeIDs);
        Post warrenUpdate1 = new Post("I work hard.", null, null, 0, null, idToPosts, idToEmbraceeIDs);
        Post warrenUpdate2 = new Post("WeSpeak will succeed.", null, null, 0, null, idToPosts, idToEmbraceeIDs);
        Post warrenUpdate3 = new Post("Billion dollar company.", null, null, 0, null, idToPosts, idToEmbraceeIDs);

        warrenUpdate0.addComment(1, "Damn daniel");
        warrenUpdate0.addComment(2, "Cats love dogs");
        warrenUpdate0.addComment(1, "Zam zaddy");

        for (Post.Comment c : warrenUpdate0.getComments())
        System.out.println(c.toString());                                                                               // prints the above comments

        System.out.println("Warren's embracees' posts:");
        if (Account.showEmbraceePosts(1, idToPosts) != null) {
            for (Post post : Account.showEmbraceePosts(0, idToPosts)) {
                System.out.println(post.toVisual());                                                                        // prints warren's embracees' posts
            }
        }

        System.out.println("Kelvin's embracees' posts:");
        if (Account.showEmbraceePosts(1, idToPosts) != null) {
            for (Post post : Account.showEmbraceePosts(1, idToPosts)) {
                System.out.println(post.toVisual());
            }
        }

        // testing password encryption
        System.out.println(Account.showPass(0, idToAcc));
        System.out.println(Account.showPass(1, idToAcc));
        System.out.println(Account.showPass(2, idToAcc));
        System.out.println(Account.showPass(3, idToAcc));

        // test login
        System.out.println(Login.login("kelly@gmail.com", "lebronkobe", loginInfo));                                    // true
        System.out.println(Login.login("blueberry@gmail.com", "helloworld", loginInfo));                                // false
        System.out.println(Login.login("blueberry@gmail.com", "nickthefrick", loginInfo));                              // true

        // test Autocomplete
        Term[] match0 = Autocomplete.autocomplete("C", interests_Database);                                             // China, Cooking, Culture
        for (Term match : match0)
        System.out.println(match.toString());

        Term[] match1 = Autocomplete.autocomplete("Fo", interests_Database);                                            // Food, Fortnite
        for (Term match : match1)
        System.out.println(match.toString());
    }
}
