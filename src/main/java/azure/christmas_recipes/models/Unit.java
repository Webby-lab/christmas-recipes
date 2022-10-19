package azure.christmas_recipes.models;

public enum Unit {
    KG("kg"), G("g"), PIECE("piece"), LITER("liter"), MILILITER("mililiter"), SPOON("spoon"), TEASPOON("teaspoon"), CUP("cup");
    private String text;

    Unit() {
    }

    Unit(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
