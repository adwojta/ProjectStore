/// <reference types="Cypress" />

describe('login-test', () => {
    it('login should work', () => {
      
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
      //cy.location('/login', {timeout: 20000}).should('include', '/');

      //cy.visit('/');

      cy.get('.login').click();
      cy.get('#wyloguj').click()
      cy.wait(500)

    });
  });