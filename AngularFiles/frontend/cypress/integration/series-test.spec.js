/// <reference types="Cypress" />

describe('series-test', () => {
    it('serie lego should work', () => {
      cy.visit('/'); 
  
      
      cy.get('[routerlink="series"]').click()
      cy.get(':nth-child(1) > app-serie-preview > .container > a > .card > img').click()
      cy.get(':nth-child(1) > app-product-preview > .container > a > .card')
      cy.get(':nth-child(1) > app-product-preview > .container > a > .card > img').click()
      cy.get('.main > img')
      cy.get('.info')
      cy.get('.info > :nth-child(3)').contains('Seria: City')
      

    });
  });