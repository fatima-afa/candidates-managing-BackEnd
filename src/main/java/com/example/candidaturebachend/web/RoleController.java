/*package com.example.candidaturebachend.web;

import com.example.candidaturebachend.entities.Role;
import com.example.candidaturebachend.repositories.RoleRepository;
import com.example.candidaturebachend.services.servicesImpl.RoleServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;*//*

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleServiceImpl roleService;
    @Autowired
    RoleRepository roleRepo;


    @GetMapping("/all")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.findAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable("id") Integer id) {
        Role role = roleService.findRoleById(id);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        Role newRole = roleService.addRole(role);
        return new ResponseEntity<>(newRole, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Role> updateRole(@RequestBody Role role) {
        Role updateRole = roleService.updateRole(role);
        return new ResponseEntity<>(updateRole, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable("id") Integer id) {
        roleService.deleteRole(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
*/