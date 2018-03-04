package shiro.controller.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import shiro.entity.Oauth2Client;
import shiro.service.OauthClientService;

/**
 * Created by sunjx on 2018/3/3.
 */
@Controller
@RequestMapping("/oauth/client")
public class OauthClientController {

    @Autowired
    private OauthClientService oauthClientService;

    //客户端列表页
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("list", oauthClientService.findAll());
        return "oauth/list";
    }

    //创建客户端页
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model){
        model.addAttribute("client", new Oauth2Client());
        model.addAttribute("op", "新增");
        return "oauth/edit";
    }

    //提交创建客户端
    @RequestMapping(value = "/create" , method = RequestMethod.POST)
    public String create(Oauth2Client client,RedirectAttributes redirectAttributes){
        oauthClientService.createClient(client);
        redirectAttributes.addFlashAttribute("msg","新增成功");
        return "redirect:/oauth/client";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("client", oauthClientService.findOne(id));
        model.addAttribute("op", "修改");
        return "oauth/edit";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(Oauth2Client client, RedirectAttributes redirectAttributes) {
        oauthClientService.updateClient(client);
        redirectAttributes.addFlashAttribute("msg", "修改成功");
        return "redirect:/oauth/client";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String showDeleteForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("client", oauthClientService.findOne(id));
        model.addAttribute("op", "删除");
        return "oauth/edit";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        oauthClientService.deleteClient(id);
        redirectAttributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/oauth/client";
    }

}
