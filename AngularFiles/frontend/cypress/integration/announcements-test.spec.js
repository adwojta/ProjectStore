/// <reference types="Cypress" />

describe('announcements-test', () => {
    it('serie lego should work', () => {
      cy.visit('/'); 
  
      
      cy.get('[routerlink="announcements"]').click()
      cy.get(':nth-child(1) > app-product-preview > .container > a > .card')
      cy.get(':nth-child(1) > app-product-preview > .container > a > .card > img').click()
      cy.get('.info')
      cy.get('.main > img')
      cy.get('.info > :nth-child(1)').contains('Avengers Lotniskowiec')
      
      

    });
  });