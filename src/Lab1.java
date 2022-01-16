public class Lab1 {
    public static void main(String[] args){
        //Create normal car
        char [][]myArray = make_forward();
        printArray(myArray);

        //Create mirrored car
        char [][]mirroredArray = make_mirror(make_forward());
        printArray(mirroredArray);

        //Make a car crash.
        printCarCrash(myArray,mirroredArray);
    }
    public static char[][] make_forward(){
            char[][] pixel = new char[4][13];
            pixel[0][0]=' ';
            pixel[0][1]=' ';
            pixel[0][2]='_';
            pixel[0][3]='_';
            pixel[0][4]='_';
            pixel[0][5]='_';
            pixel[0][6]='_';
            pixel[0][7]='_';
            pixel[0][8]=' ';
            pixel[0][9]=' ';
            pixel[0][10]=' ';
            pixel[0][11]=' ';
            pixel[0][12]=' ';
            pixel[1][0]=' ';
            pixel[1][1]='/';
            pixel[1][2]='|';
            pixel[1][3]='_';
            pixel[1][4]='|';
            pixel[1][5]='|';
            pixel[1][6]='_';
            pixel[1][7]='\\';
            pixel[1][8]='\'';
            pixel[1][9]='.';
            pixel[1][10]='_';
            pixel[1][11]='_';
            pixel[1][12]=' ';
            pixel[2][0]='(';
            pixel[2][1]=' ';
            pixel[2][2]=' ';
            pixel[2][3]=' ';
            pixel[2][4]='_';
            pixel[2][5]=' ';
            pixel[2][6]=' ';
            pixel[2][7]=' ';
            pixel[2][8]=' ';
            pixel[2][9]='_';
            pixel[2][10]=' ';
            pixel[2][11]='_';
            pixel[2][12]='\\';
            pixel[3][0]='=';
            pixel[3][1]='\'';
            pixel[3][2]='-';
            pixel[3][3]='(';
            pixel[3][4]='_';
            pixel[3][5]=')';
            pixel[3][6]='-';
            pixel[3][7]='-';
            pixel[3][8]='(';
            pixel[3][9]='_';
            pixel[3][10]=')';
            pixel[3][11]='-';
            pixel[3][12]='\'';
            return pixel;
        }

    //todo fix make mirror array!

    public static char[][] make_mirror(char[][] mirroredArray){
        /*As you copy each character, check the table below to see if the character itself needs to
        be reversed. If the character is not in the table, copy it as normal, but if it is in the table,
        replace it with the “Mirrored” character. You will need if statements for this.*/
        for (int i=0;i<mirroredArray.length;i++){
            for(int j=0;j<(mirroredArray[1].length-1)/2;j++){
                switch (mirroredArray[i][j]){
                    case '(':
                    case ')':
                    case '/':
                    case '\\':
                        //Mirror the input, then check the second index we're changing to make sure it cant also be reversed, then swap places.
                        char mirror = getOpposite(mirroredArray[i][j]);
                        char secondMirror;
                            switch (mirroredArray[i][12-j]){
                                case '(':
                                case ')':
                                case '/':
                                case '\\':
                                    secondMirror = getOpposite(mirroredArray[i][12-j]);
                                    break;
                                default:
                                    secondMirror = mirroredArray[i][12-j];
                            }
                        mirroredArray[i][12-j] = mirror;
                        mirroredArray[i][j] = secondMirror;
                        break;
                    default:
                        //Switch places if we didnt need to mirror it first.
                        char temp = mirroredArray[i][j];
                        mirroredArray[i][j] = mirroredArray[i][12-j];
                        mirroredArray[i][12-j] = temp;
                        break;
                }
            }
        }
        return mirroredArray;
    }

    public static char getOpposite(char character){
        switch (character){
            case '(':
                return ')';
            case ')':
                return '(';
            case '/':
                return '\\';
            case '\\':
                return '/';
            default:
                return 'z';
        }
    }

    public static void printArray(char[][] myArray){
        for (int i=0;i< myArray.length;i++){
            for(int j=0;j< myArray[1].length;j++){
                System.out.print(myArray[i][j]);
            }
            System.out.println();
        }
    }
    //TODO fully implement this!
    public static void printCarCrash(char[][] myArray,char[][] mirroredArray){
        for(int i=0;i<myArray.length;i++){
            for(int j=0;j< myArray[1].length;j++){
                System.out.print(myArray[i][j]);
                }
            for (int k=0;k<mirroredArray[1].length;k++){
                System.out.print(mirroredArray[i][k]);
            }
            System.out.println();
        }
    }
}
