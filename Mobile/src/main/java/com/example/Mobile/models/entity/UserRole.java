package com.example.Mobile.models.entity;

import com.example.Mobile.models.entity.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "userRoles")
public class UserRole extends BaseEntity{

   @Enumerated(EnumType.STRING)
   private Role role;  // – enumerated value.

   public UserRole() {
   }

   public Role getRole() {
      return role;
   }

   public void setRole(Role role) {
      this.role = role;
   }
}
