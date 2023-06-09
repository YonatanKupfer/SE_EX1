public class Contact {
    private String name;
    private String number;

    public Contact(String name, String number){
        this.name = name;
        this.number = number;
        if(!validateNumber()){
            this.number = "0000000";
            System.out.println("Invalid number, set to 0000000");
            
        }
        
    }

    public Contact(){
        this.name = "";
        this.number = "";
    }

    public void printContact(){
        System.out.println(this.name + " " + this.number);
    }

    public boolean equals(Contact other){
        if(this.name.equals(other.name) && this.number.equals(other.number)){
            return true;
        }
        return false;
    }

    public boolean validateNumber(){
        for(int i = 0; i < this.number.length(); i++){
            if(!Character.isDigit(this.number.charAt(i))){
                return false;
            }
        }
        return true;
    }


    public String getName(){
        return this.name;
    }

    public String getNumber(){
        return this.number;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setNumber(String number){
        this.number = number;
    }

    //Override
    public String toString(){
        return this.name + " " + this.number;
    }


}
