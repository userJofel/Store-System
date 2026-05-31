package loja.model;

public class Cliente {
    private static int nextId = 1;
    private final int id;
    private final String nome;
    private String email;

    public Cliente(String nome, String email) {
        this.id = nextId;
        this.nome = nome;
        this.email = email;
        nextId++;
    }

    public int getId() { return this.id; }
    public String getNome() { return this.nome; }
    public String getEmail() { return this.email; }

    @Override
    public String toString() {return ( this.getId() + "# | Nome: " + this.getNome() + " | Email: " + this.getEmail());}
}
