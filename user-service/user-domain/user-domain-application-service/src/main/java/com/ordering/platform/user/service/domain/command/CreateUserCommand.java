package com.ordering.platform.user.service.domain.command;

public record CreateUserCommand (String firstName, String lastName, String email, String address) {

     public static final class Builder {
         private String firstName;
         private String lastName;
         private String email;
         private String address;

         public Builder firstName (String firstName){
             this.firstName = firstName;
             return this;
         }

         public Builder lastName (String lastName){
             this.lastName = lastName;
             return this;
         }

         public Builder email (String email){
             this.email = email;
             return this;
         }

         public Builder address (String address){
             this.address = address;
             return this;
         }

         public CreateUserCommand build (){
             return new CreateUserCommand(firstName, lastName, email, address);
         }
     }
}
