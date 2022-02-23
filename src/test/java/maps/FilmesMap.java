package maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilmesMap {
    public static int id;
    private static Map<String, String> header;
    private static Map<String, Object> filme;
    private static Map<String, Object> categorias1;
    private static Map<String, Object> categorias2;
    private static Map<String, Object> plataforma;
    private static List<Map<String, Object>> listCategoria;
    private static List<Map<String, Object>> listPlataforma;

    public static Map<String, String> getHeader() {
        return header;
    }

    public static void setHeader(Map<String, String> header) {
        FilmesMap.header = header;
    }

    public static Map<String, Object> getFilme() {
        return filme;
    }

    public static void setFilme(Map<String, Object> filme) {
        FilmesMap.filme = filme;
    }

    public static Map<String, Object> getCategorias1() {
        return categorias1;
    }

    public static void setCategorias1(Map<String, Object> categorias1) {
        FilmesMap.categorias1 = categorias1;
    }

    public static Map<String, Object> getCategorias2() {
        return categorias2;
    }

    public static void setCategorias2(Map<String, Object> categorias2) {
        FilmesMap.categorias2 = categorias2;
    }

    public static Map<String, Object> getPlataforma() {
        return plataforma;
    }

    public static void setPlataforma(Map<String, Object> plataforma) {
        FilmesMap.plataforma = plataforma;
    }

    public static List<Map<String, Object>> getListCategoria() {
        return listCategoria;
    }

    public static void setListCategoria(List<Map<String, Object>> listCategoria) {
        FilmesMap.listCategoria = listCategoria;
    }

    public static List<Map<String, Object>> getListPlataforma() {
        return listPlataforma;
    }

    public static void setListPlataforma(List<Map<String, Object>> listPlataforma) {
        FilmesMap.listPlataforma = listPlataforma;
    }

    public static void initCategoria(){
        listCategoria = new ArrayList<>();
        categorias1 = new HashMap<>();
        categorias2 = new HashMap<>();

        categorias1.put("tipo", "Ação");
        categorias2.put("tipo", "Comédia");

        listCategoria.add(categorias1);
        listCategoria.add(categorias2);
    }

    public static void initHeader(){
        header =  new HashMap<>();
        header.put("Authorization", "Bearer " + LoginMap.token);
    }

    public static void initPlataforma(){
        listPlataforma = new ArrayList<>();
        plataforma = new HashMap<>();
        plataforma.put("nome", "NetFlix");
        listPlataforma.add(plataforma);
    }

    public static void initFilme(){
        filme = new HashMap<>();
        filme.put("nome", "Alerta Vermelhor");
        filme.put("descricao", "Um alerta vermelho da Interpol é emetido e o agente do FBI");
        filme.put("duracao", 1.35);
        filme.put("categorias", listCategoria);
        filme.put("plataformas",listPlataforma);
    }

    public static  void initAll(){
        initHeader();
        initCategoria();
        initPlataforma();
        initFilme();
    }
}
