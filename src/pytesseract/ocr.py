import os
import pytesseract
from PIL import Image


class OCR:
    def __init__(self, file: str) -> None:
        self.file = file

    def scan(self):
        image = Image.open(self.file)
        result = pytesseract.image_to_string(image, lang="ori")
        return result

    def save(self, text: str):
        with open(f"{os.path.basename(file).split('.')[0]}.txt", "w", encoding="utf-8") as f:
            f.write(text)


file = "odia2.jpg"
ocr = OCR(file)
result = ocr.scan()
ocr.save(result)
