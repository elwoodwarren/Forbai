import java.util.HashMap;
import java.util.Arrays;
import java.util.LinkedList;

public class Debug {
    public static void main(String[] args) {
        HashMap<String, LinkedList<Integer>> countries_Database = new HashMap<String, LinkedList<Integer>>();
        HashMap<String, LinkedList<Integer>> interests_Database = new HashMap<String, LinkedList<Integer>>();
        HashMap<String, String> loginInfo = new HashMap<String, String>();
        HashMap<String, Integer> userToID = new HashMap<String, Integer>();
        HashMap<Integer, Account> idToAcc = new HashMap<Integer, Account>();
        Queue<Integer> suspendedAccs = new Queue<Integer>();                                                            // database of suspended accounts

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

        // TESTS SEARCH, ACCOUNT CREATION, & ADDING/REMOVING INTERESTS

        Account.create("Warren", "Elwood", 19, "USA", "warren@gmail.com", "warrenelwood12", "password12", true, new Picture(args[0]),
        countries_Database, interests_Database, loginInfo, userToID, idToAcc);
        Account.create("Kelvin", "Yu", 19, "China", "kelly@gmail.com", "zkyu2", "kobebyrnat24", true, new Picture(args[1]),
        countries_Database, interests_Database, loginInfo, userToID, idToAcc);
        Account.create("Nick", "Turk", 20, "USA", "nickturk@gmail.com", "nturk12", "rogerfreder33", true, new Picture(args[0]),
        countries_Database, interests_Database, loginInfo, userToID, idToAcc);
        Account.create("Hong", "Xia", 50, "China", "blueberry@gmail.com", "lynna_xia", "password3", false, new Picture(args[1]),
        countries_Database, interests_Database, loginInfo, userToID, idToAcc);

        Account.addInterest(0, "Food", interests_Database, idToAcc);
        Account.addInterest(0, "Fornite", interests_Database, idToAcc);
        Account.addInterest(0, "Lebron James", interests_Database, idToAcc);
        Account.addInterest(0, "Drums", interests_Database, idToAcc);
        Account.addInterest(0, "Music", interests_Database, idToAcc);
        Account.addInterest(1, "Food", interests_Database, idToAcc);
        Account.addInterest(1, "Culture", interests_Database, idToAcc);
        Account.addInterest(1, "China", interests_Database, idToAcc);
        Account.addInterest(1, "Investing", interests_Database, idToAcc);
        Account.addInterest(2, "Music", interests_Database, idToAcc);
        Account.addInterest(2, "Food", interests_Database, idToAcc);
        Account.addInterest(2, "Fortnite", interests_Database, idToAcc);
        Account.addInterest(2, "Tennis", interests_Database, idToAcc);
        Account.addInterest(3, "China", interests_Database, idToAcc);
        Account.addInterest(3, "Music", interests_Database, idToAcc);
        Account.addInterest(3, "Cooking", interests_Database, idToAcc);
        Account.addInterest(3, "Food", interests_Database, idToAcc);

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

        System.out.println("Kelvin's username is: " + Account.showUser(1, idToAcc));                                // labron
        System.out.println("Nick's password is: " + Account.showPass(2, idToAcc));                                  // nickthefrick
        System.out.println("Warren's email is: " + Account.showEmail(0, idToAcc));                                  // weee@uo.com

        Account.addInterest(2, "Hello Kitty", interests_Database, idToAcc);
        System.out.println("Nick's interests: " + Arrays.toString(Account.interestList(2, idToAcc)));               // tests if interest is inserted at correct spot

        // TESTS CHATS/MESSAGES
        HashMap<String, GroupChat> titleToChat = new HashMap<String, GroupChat>();

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

        GroupChat groupChat0 = new GroupChat(1, "Is Trump a good president?", titleToChat, idToAcc);
        groupChat0.addUser(0, idToAcc);
        groupChat0.addUser(2, idToAcc);
        groupChat0.addUser(3, idToAcc);
        groupChat0.removeUser(2, idToAcc, titleToChat);

        groupChat0.addMessage("Do y'all like Donald Trump?", null, null, 0);
        groupChat0.addMessage("What's wrong with him?", null, null, 1);
        groupChat0.addMessage("He's a clown?", null, null, 2);
        groupChat0.addMessage("You cray", null, null, 3);
        groupChat0.addMessage("Yeah I like him", null, null, 0);
        groupChat0.addMessage("Homie are you dumb", null, null, 3);

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
        GroupChat groupChat1 = new GroupChat(1, "I love Donald Trump.", titleToChat, idToAcc);
        GroupChat groupChat2 = new GroupChat(1, "I hate Donald Trump!", titleToChat, idToAcc);
        GroupChat groupChat3 = new GroupChat(1, "What are some good things Trump has done?", titleToChat, idToAcc);
        GroupChat groupChat4 = new GroupChat(1, "I love Kendrick", titleToChat, idToAcc);
        GroupChat groupChat5 = new GroupChat(1, "I love nice people.", titleToChat, idToAcc);
        GroupChat groupChat6 = new GroupChat(1, "Is Trump a bad president?", titleToChat, idToAcc);
        GroupChat groupChat7 = new GroupChat(1, "I love food.", titleToChat, idToAcc);
        GroupChat groupChat8 = new GroupChat(1, "Private equity is fun.", titleToChat, idToAcc);
        GroupChat groupChat9 = new GroupChat(1, "Venture capital is fun.", titleToChat, idToAcc);
        GroupChat.deleteChat(groupChat5, titleToChat);
        groupChat1.removeUser(1, idToAcc, titleToChat);

        GroupChat[] matches8 = SearchDiscussions.search("Trump", titleToChat);                                          // test DiscussionSearch
        GroupChat[] matches9 = SearchDiscussions.search("love", titleToChat);
        GroupChat[] matches10 = SearchDiscussions.search("trump", titleToChat);

        for (String t : titleToChat.keySet())
        System.out.println(t);

        System.out.println("Chat titles with 'Trump' : ");
        for (int i = 0; i < matches8.length; i++) {
            if (matches8[i] == null)
            continue;
            System.out.println(matches8[i].showTitle());
        }

        System.out.println("Chat titles with 'love' : ");
        for (int i = 0; i < matches9.length; i++) {
            if (matches9[i] == null)
            continue;
            System.out.println(matches9[i].showTitle());
        }

        System.out.println("Chat titles with 'trump' : ");
        for (int i = 0; i < matches10.length; i++) {
            if (matches10[i] == null)
            continue;
            System.out.println(matches10[i].showTitle());
        }

        // TESTS EMBRACING PEOPLE
        HashMap<Integer, LinkedList<Integer>> idToEmbraceeIDs = new HashMap<Integer, LinkedList<Integer>>();

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
        Account.removeEmbracee(1, 0, idToEmbraceeIDs, idToAcc);
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
        Account.report(0, "They're trolling", idToAcc, suspendedAccs);
        Account.report(1, "Spam account", idToAcc, suspendedAccs);
        Account.report(0, "They're extremely rude", idToAcc, suspendedAccs);
        System.out.println("Warren has " + Account.reportNum(0, idToAcc) + " reports");
        System.out.println("Kelvin has " + Account.reportNum(1, idToAcc) + " reports");

System.out.println(Account.getNumberOfInterests(1, idToAcc));                                                           // 3
System.out.println(Account.getNumberOfChats(1, idToAcc));                                                               // 10
System.out.println(groupChat0.getAdmin());                                                                              // 1
    }
}
