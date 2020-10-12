FROM python:alpine

RUN pip install requests

WORKDIR /script

COPY dataloader.py /script

RUN chmod a+x /script/dataloader.py

RUN echo $(ls -la )
RUN echo $(ls -la /script )

ENTRYPOINT ["python"]