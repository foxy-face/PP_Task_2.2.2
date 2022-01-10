package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;

import java.util.Optional;

@Controller
public class CarsController {
    private final CarDao carDao;

    @Autowired
    public CarsController(CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count") Optional<Integer> count, Model model) {
        model.addAttribute("cars", carDao.getCarsByCount(count.orElse(0)));
        return "cars";
    }
}
