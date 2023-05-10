package it.marconiverona.ColoriRAL.restcontroller;

import dao.DAO;
import entity.domain.Colore;
import entity.domain.Gradazione;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "coloriral")
public class ColoriRalController {

    @Operation(summary = "Aggiunta categoria di colore", description = "Metodo di aggiungere una nuova categoria")
    @PostMapping(path = "categorie/add")
    public void add(@RequestBody Gradazione g){
        DAO.getGradazioneDAO().addGradazione(g);
    }
    @Operation(summary = "Presa tutte categorie", description = "Metodo di prendere tutte le categorie")
    @GetMapping(path="categorie/all")
    public List<Gradazione> getAllGradazione() {
        return DAO.getGradazioneDAO().getAll();
    }

    @Operation(summary = "Prende una categoria in base al nome", description = "Metodo di prendere una certa categoria in base al nome")
    @GetMapping("categorie/{nome}")
    @ResponseBody
    public Gradazione getCategoriaByNome(@PathVariable String nome) {
        return DAO.getGradazioneDAO().getByNome(nome);
    }

    @Operation(summary = "Aggiunta colore", description = "Metodo di aggiungere una nuovo colore")
    @PostMapping(path = "colori/add")
    public void add(@RequestBody Colore c){
        DAO.getColoreDAO().addColore(c);
    }

    @Operation(summary = "Presi tutti i colori", description = "Metodo per prendere tutti i colori")
    @GetMapping(path="colori/all")
    public List<Colore> getAllColori() {
        return DAO.getColoreDAO().getAll();
    }

    @Operation(summary = "Preso il colore in base a codice", description = "Metodo per prendere il colore in base ad un codice fornito")
    @GetMapping("colori/{codice}")
    @ResponseBody
    public Colore getColoreByNome(@PathVariable String codice) {
        return DAO.getColoreDAO().getByCodice(codice);
    }

    @Operation(summary = "Cancella colore in base al codice", description = "Metodo per cancellare il colore in base ad un codice fornito")
    @DeleteMapping("colori/{codice}")
    public void delColoreByCodice(@PathVariable String codice) {
        DAO.getColoreDAO().delColoreByCodice(codice);
    }

    @GetMapping(path="categorie/{codice}/colori")
    @Operation(summary="Data un codice categoria ottieni colori", description="Data un codice categoria ottieni colori")
    public List<Colore> getColoryByCategoriaCodice(@PathVariable(name = "codice") String codice){
        Gradazione grad = DAO.getGradazioneDAO().getByCodice(codice);
        return DAO.getColoreDAO().getByGradazione(grad);
    }

    @GetMapping(path="colori/{nome}/categorie")
    @Operation(summary="Dato nome colore ottieni categoria", description="Dato nome colore ottieni categoria")
    public Gradazione getCategoriaByColoreCodice(@PathVariable(name = "nome") String nome){
        return DAO.getColoreDAO().getByNome(nome).getGradazione();
    }
}
