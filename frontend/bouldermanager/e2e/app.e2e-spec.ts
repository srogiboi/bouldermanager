import { BouldermanagerPage } from './app.po';

describe('bouldermanager App', function() {
  let page: BouldermanagerPage;

  beforeEach(() => {
    page = new BouldermanagerPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
