package com.apprh.apprh.controllers;

import com.apprh.apprh.models.Candidato;
import com.apprh.apprh.models.Vaga;
import com.apprh.apprh.repository.CandidatoRepository;
import com.apprh.apprh.repository.VagaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

@Controller
public class VagaController {

    @Autowired
    private VagaRepository vr;

    @Autowired
    private CandidatoRepository cr;


    //CADASTRAR VAGA
    //FORMULARIO DE CADASTRO DE VAGA
    @RequestMapping(value = "/cadastrarVaga", method = RequestMethod.GET)
    public String form() {
        return "vaga/formVaga";
    }

    //CADASTRA VAGAS
    @RequestMapping(value = "/cadastrarVaga", method = RequestMethod.POST)
    public String form(@Valid Vaga vaga, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos...");
            return "redirect:/cadastrarVaga";
        }

        vr.save(vaga);
        attributes.addFlashAttribute("mensagem", "Vaga cadastrada com sucesso!");
        return "redirect:/cadastrarVaga";
    }


    //LISTAR VAGAS
    @RequestMapping("/vagas")
    public ModelAndView listVagas() {

        ModelAndView mv = new ModelAndView("vaga/listaVaga");

        Iterable<Vaga> vagas = vr.findAll();
        mv.addObject("vagas", vagas);

        return mv;
    }

    //DETALHES VAGAS
    @RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
    public ModelAndView detalhesVaga(@PathVariable("codigo") long codigo) {

        Vaga vaga = vr.findByCodigo(codigo);

        ModelAndView mv = new ModelAndView("vaga/detalhesVaga");
        mv.addObject("vaga", vaga);

        Iterable<Candidato> candidatos = cr.findByVaga(vaga);
        mv.addObject("candidatos", candidatos);

        return mv;
    }

    //DELETA A VAGA
    @RequestMapping("/deletarVaga")
    public String deletarVaga(long codigo) {

        Vaga vaga = vr.findByCodigo(codigo);
        vr.delete(vaga);

        return "redirect:/vagas";
    }

    //ADICIONAR CANDIDATO
    @RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
    public String detalhesVagasPost(@PathVariable("codigo") long codigo,
                                    @Valid Candidato candidato,
                                    BindingResult result,
                                    RedirectAttributes attributes) {


        if (result.hasErrors()) {

            FieldError fieldError = result.getFieldError();//verifica volta null
            //se for diferente de null volta a mensagem especifica se não volta uma mensagem generica
            String mensagemErro = (fieldError != null) ? fieldError.getDefaultMessage() : "Verifique os campos...";
            attributes.addFlashAttribute("mensagem_erro", mensagemErro);
            return "redirect:/{codigo}";
        }

        if (cr.findByRg(candidato.getRg()) != null) {
            attributes.addFlashAttribute("mensagem_erro", "RG duplicado");
            return "redirect:/{codigo}";
        }

        Vaga vaga = vr.findByCodigo(codigo);
        candidato.setVaga(vaga);

        cr.save(candidato);
        attributes.addFlashAttribute("mensagem", "Candidato adicionado com sucesso!");

        return "redirect:/{codigo}";
    }

    //DELETA CANDIDATO RG
    @RequestMapping("/deletarCandidato")
    public String deletarCandidato(String rg) {

        Candidato candidato = cr.findByRg(rg);
        Vaga vaga = candidato.getVaga();
        String codigo = "" + vaga.getCodigo();

        cr.delete(candidato);

        return "redirect:/" + codigo;
    }

    //METODOS QUE ATUALIZAM VAGAS
    //FORMULARIO DE EDIÇÃO DE VAGA
    @RequestMapping(value = "/editar-vaga", method = RequestMethod.GET)
    public ModelAndView editarVaga(long codigo) {

        Vaga vaga = vr.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("vaga/update-vaga");

        mv.addObject("vaga", vaga);
        return mv;
    }

    //UPDATE VAGA
    @RequestMapping(value = "/editar-vaga", method = RequestMethod.POST)
    public String updateVaga(@Valid Vaga vaga, BindingResult result, RedirectAttributes attributes) {

        vr.save(vaga);
        attributes.addFlashAttribute("success", "Vaga alterada com sucesso!");

        long codigoLong = vaga.getCodigo();
        String codigo = "" + codigoLong;

        return "redirect:/" + codigo;

    }

}
