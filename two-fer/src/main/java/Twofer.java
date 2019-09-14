class Twofer {
    String twofer(String name) {

      if(name == null){
        return "One for you, one for me.";
      } else {
        String fer = "One for ";
        fer += name + ", one for me.";
        return fer;
      }
    }
}
