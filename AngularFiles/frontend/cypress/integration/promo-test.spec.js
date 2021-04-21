/// <reference types="Cypress" />

describe('promo-test', () => {
    it('promo lego should work', () => {
      cy.visit('/'); 
  
      
      cy.get('[routerlink="promo"]').click()

      cy.get(':nth-child(6) > app-product-preview > .container > a > .card')
      cy.get(':nth-child(6) > app-product-preview > .container > a > .card > img').click()

      
      cy.get('.info')
      cy.get('.main > img')

      cy.get('.info > :nth-child(1)').contains('Żołnierze-klony z 501. legionu')
    
    });
  });