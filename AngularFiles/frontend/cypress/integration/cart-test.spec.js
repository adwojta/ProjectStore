/// <reference types="Cypress" />

describe('cart-test', () => {
    it('adding should work', () => {

      cy.visit('/'); 
      cy.get('[routerlink="promo"]').click()
      cy.get(':nth-child(1) > app-product-preview > .container > a > .card > img').click()
      
      cy.get('.info > button').click()
cy.wait(5000)
      cy.get('.cart > a').click()
      cy.get('div.ng-star-inserted > :nth-child(2)').contains('Kopalnia Creeperów')

    });
  });