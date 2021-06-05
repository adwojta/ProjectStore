/// <reference types="Cypress" />

describe('comment-test', () => {
    it('commenting should work', () => {
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

      cy.visit('/'); 
      cy.get('[routerlink="promo"]').click()
      cy.get(':nth-child(1) > app-product-preview > .container > a > .card > img').click()
      

      cy.get('#rating')
      .type('3')
      .should('have.value', '3');

      cy.get('#description')
      .type('komentarz testowy')
      .should('have.value', 'komentarz testowy');

      cy.get('#comment').submit();
      cy.wait(5000)
      cy.get('.login').click();
      cy.get('#wyloguj').click()
      cy.wait(500)

    });
  });