package br.com.mvc.mudi.controller;

import javax.validation.Valid;

import br.com.mvc.mudi.controller.repository.PedidoRepository;
import br.com.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.mvc.mudi.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedido requisicao) {
        return "pedido/formulario";

    }
    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
        if (result.hasErrors()) {
            return "pedido/formulario";
        }
        Pedido pedido = requisicao.toPediddo();
        pedidoRepository.save(pedido);
        return "redirect:/home";
    }
}
