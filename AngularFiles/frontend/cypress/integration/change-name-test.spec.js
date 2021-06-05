/// <reference types="Cypress" />

describe('change-name-test', () => {
    it('change name should work', () => {
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
      cy.get('#toggle-1-header > .btn').click()

      cy.get('#name').type('Test');
      cy.get('#surname').type('Test');
      cy.get('#change1').submit()
      cy.wait(500)
      

      cy.get('#wyloguj').click()
      cy.wait(500)

    });
  });