/// <reference types="Cypress" />

describe('shopping-test', () => {
    it('shopping should work', () => {
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

      cy.get('[routerlink="promo"]').click()
      cy.get(':nth-child(3) > app-product-preview > .container > a > .card > img').click()    
      cy.get('.info > button').click()
      cy.wait(5000)
      //cy.get('#quantity').type('1')
      cy.get('.cart > a').click()
      cy.wait(500)

      cy.get('#dalej').click()
      cy.wait(500)

      cy.get('#submitInfo').click()
      cy.wait(500)
      cy.get('#kup').click()
      cy.wait(5000)

      cy.get('.login').click();
      cy.get('#wyloguj').click()
      cy.wait(500)

    });
  });