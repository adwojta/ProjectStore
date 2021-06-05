/// <reference types="Cypress" />

describe('change-password-test', () => {
    it('change password should work', () => {
      cy.visit('/'); 
      cy.get('[routerlink="login"]').click()
      cy.get('#username')
      .type('magicznyMarian')
      .should('have.value', 'magicznyMarian');
      cy.get('#password')
      .type('haslo')
      .should('have.value', 'haslo');
      cy.get('#login').submit();
      cy.wait(500)
      cy.get('.login').click();
      cy.get('#toggle-2-header > .btn').click()


      cy.get('#OldPassword').type('haslo');
      cy.get('#NewPassword').type('haslo');
      cy.get('#change2').submit()
      cy.wait(500)
      

      cy.get('#wyloguj').click()
      cy.wait(500)

    });
  });