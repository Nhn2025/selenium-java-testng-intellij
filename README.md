public void dragAndDropByJS(WebElement source, WebElement target) {
    String script = "const dataTransfer = new DataTransfer();" +
                    "source.dispatchEvent(new DragEvent('dragstart', { dataTransfer: dataTransfer }));" +
                    "target.dispatchEvent(new DragEvent('drop', { dataTransfer: dataTransfer }));" +
                    "source.dispatchEvent(new DragEvent('dragend', { dataTransfer: dataTransfer }));";
    ((JavascriptExecutor) driver).executeScript(script, source, target);
}
