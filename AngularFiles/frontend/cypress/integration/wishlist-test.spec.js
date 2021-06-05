/// <reference types="Cypress" />

describe('wishlist-test', () => {
    it('wishlist should work', () => {
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
      cy.get(':nth-child(1) > app-product-preview > .container > a > .card > img').click()
      cy.get('#dodaj').click()

      cy.get('.login').click()
      cy.get('#wyloguj').click()
      cy.wait(500)

    });
});