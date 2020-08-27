package classes;

import java.util.Comparator;

public  class TeamMember implements Comparable{
    int id;
    String name;
    String email;

    public TeamMember(){
     }

     public TeamMember(int id, String name, String email) {
        this.id = id;
        this.name = name.trim();
         String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
         if (email.matches(regex)) {
             this.email = email;
         }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }
@Override
    public String toString() {
     return   name +" " +email ;
    }

    public static Comparator<TeamMember> NameComparator = new Comparator<TeamMember>() {
        @Override
        public int compare(TeamMember o1, TeamMember o2) {
            String Name1 = o1.getName().toUpperCase();
            String Name2 = o2.getName().toUpperCase();
            return Name1.compareTo(Name2);
        }
    };

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
